package com.example.githubapp.ui.repository

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapp.data.model.Issue
import com.example.githubapp.data.model.Repository
import com.example.githubapp.data.repository.GithubRepository
import com.example.githubapp.util.NetworkUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoryViewModel @Inject constructor(
    private val githubRepository: GithubRepository,
    private val networkUtils: NetworkUtils,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val owner: String = checkNotNull(savedStateHandle["owner"])
    private val repo: String = checkNotNull(savedStateHandle["repo"])

    private val _uiState = MutableStateFlow(RepositoryUiState())
    val uiState: StateFlow<RepositoryUiState> = _uiState.asStateFlow()
    
    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn.asStateFlow()

    init {
        loadRepositoryDetails()
        observeLoginState()
    }
    
    private fun observeLoginState() {
        viewModelScope.launch {
            githubRepository.isLoggedIn().collectLatest { isLoggedIn ->
                _isLoggedIn.value = isLoggedIn
            }
        }
    }

    fun loadRepositoryDetails() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }

            // Load repository details
            githubRepository.getRepository(owner, repo)
                .onSuccess { repository ->
                    _uiState.update { it.copy(repository = repository) }
                    
                    // After successfully loading repository, load issues
                    loadRepositoryIssues()
                }
                .onFailure { error ->
                    _uiState.update { 
                        it.copy(
                            isLoading = false,
                            error = networkUtils.getErrorMessage(error)
                        )
                    }
                }
        }
    }

    private fun loadRepositoryIssues() {
        viewModelScope.launch {
            githubRepository.getRepositoryIssues(owner, repo)
                .onSuccess { issues ->
                    _uiState.update { 
                        it.copy(
                            issues = issues,
                            isLoading = false,
                            error = null
                        )
                    }
                }
                .onFailure { error ->
                    _uiState.update { 
                        it.copy(
                            isLoading = false,
                            error = networkUtils.getErrorMessage(error)
                        )
                    }
                }
        }
    }
}

data class RepositoryUiState(
    val repository: Repository? = null,
    val issues: List<Issue> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
