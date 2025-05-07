/**
 * Home Screen ViewModel
 * Manages UI state and data for the home screen
 * Fetches trending repositories from GitHub API
 * 
 * @author Aaron Luo
 * @date May 7, 2025
 */
package com.example.githubapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapp.data.model.Repository
import com.example.githubapp.data.repository.GithubRepository
import com.example.githubapp.util.NetworkUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val githubRepository: GithubRepository,
    private val networkUtils: NetworkUtils
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
    
    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn.asStateFlow()

    init {
        loadTrendingRepositories()
        observeLoginState()
    }
    
    private fun observeLoginState() {
        viewModelScope.launch {
            githubRepository.isLoggedIn().collectLatest { isLoggedIn ->
                _isLoggedIn.value = isLoggedIn
            }
        }
    }

    fun loadTrendingRepositories() {
        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading
            
            githubRepository.getTrendingRepositories()
                .onSuccess { repositories ->
                    _uiState.value = HomeUiState.Success(repositories)
                }
                .onFailure { error ->
                    _uiState.value = HomeUiState.Error(networkUtils.getErrorMessage(error))
                }
        }
    }
}

sealed class HomeUiState {
    object Loading : HomeUiState()
    data class Success(val repositories: List<Repository>) : HomeUiState()
    data class Error(val message: String) : HomeUiState()
}
