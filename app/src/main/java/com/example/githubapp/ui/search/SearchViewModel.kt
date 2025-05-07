package com.example.githubapp.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapp.data.model.Repository
import com.example.githubapp.data.repository.GithubRepository
import com.example.githubapp.util.NetworkUtils
import com.example.githubapp.util.PaginatedListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val githubRepository: GithubRepository,
    private val networkUtils: NetworkUtils
) : ViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _selectedLanguage = MutableStateFlow<String?>(null)
    val selectedLanguage = _selectedLanguage.asStateFlow()
    
    private var currentPage = 1
    private var isLastPage = false

    init {
        observeSearchQuery()
    }

    @OptIn(FlowPreview::class)
    private fun observeSearchQuery() {
        viewModelScope.launch {
            _searchQuery
                .debounce(500)
                .filter { it.isNotBlank() }
                .distinctUntilChanged()
                .collect {
                    resetSearch()
                    searchRepositories(it, _selectedLanguage.value)
                }
        }
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
        if (query.isBlank()) {
            _uiState.update { 
                it.copy(
                    paginatedList = PaginatedListState(items = emptyList(), isLoading = false, error = null)
                )
            }
        }
    }

    fun onLanguageSelected(language: String?) {
        _selectedLanguage.value = language
        if (_searchQuery.value.isNotBlank()) {
            resetSearch()
            searchRepositories(_searchQuery.value, language)
        }
    }
    
    fun loadMoreRepositories() {
        if (_uiState.value.paginatedList.isLoading || isLastPage) return
        
        val query = _searchQuery.value
        if (query.isBlank()) return
        
        currentPage++
        searchRepositories(query, _selectedLanguage.value, isLoadingMore = true)
    }
    
    private fun resetSearch() {
        currentPage = 1
        isLastPage = false
        _uiState.update { 
            it.copy(
                paginatedList = PaginatedListState(items = emptyList(), isLoading = true)
            )
        }
    }

    private fun searchRepositories(query: String, language: String?, isLoadingMore: Boolean = false) {
        viewModelScope.launch {
            if (!isLoadingMore) {
                _uiState.update { 
                    it.copy(
                        paginatedList = it.paginatedList.copy(isLoading = true, error = null)
                    )
                }
            } else {
                _uiState.update { 
                    it.copy(
                        paginatedList = it.paginatedList.copy(isLoading = true)
                    )
                }
            }

            githubRepository.searchRepositories(query, language, page = currentPage)
                .onSuccess { repositories ->
                    // Check if we've reached the last page (no more results)
                    isLastPage = repositories.isEmpty()
                    
                    _uiState.update { currentState -> 
                        val currentItems = if (isLoadingMore) {
                            currentState.paginatedList.items
                        } else {
                            emptyList()
                        }
                        
                        val updatedItems = currentItems + repositories
                        
                        currentState.copy(
                            paginatedList = PaginatedListState(
                                items = updatedItems,
                                isLoading = false,
                                endReached = isLastPage,
                                error = null
                            )
                        )
                    }
                }
                .onFailure { error ->
                    _uiState.update { 
                        it.copy(
                            paginatedList = it.paginatedList.copy(
                                isLoading = false,
                                error = networkUtils.getErrorMessage(error)
                            )
                        )
                    }
                }
        }
    }
}

data class SearchUiState(
    val paginatedList: PaginatedListState<Repository> = PaginatedListState()
)
