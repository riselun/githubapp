package com.example.githubapp.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapp.data.model.Repository
import com.example.githubapp.data.model.User
import com.example.githubapp.data.repository.GithubRepository
import com.example.githubapp.util.NetworkUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val githubRepository: GithubRepository,
    private val networkUtils: NetworkUtils
) : ViewModel() {

    private val _uiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Loading)
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    init {
        loadUserProfile()
    }

    fun loadUserProfile() {
        viewModelScope.launch {
            _uiState.value = ProfileUiState.Loading

            githubRepository.getUserProfile()
                .onSuccess { user ->
                    loadUserRepositories(user)
                }
                .onFailure { error ->
                    _uiState.value = ProfileUiState.Error(networkUtils.getErrorMessage(error))
                }
        }
    }

    private fun loadUserRepositories(user: User) {
        viewModelScope.launch {
            githubRepository.getUserRepositories()
                .onSuccess { repositories ->
                    _uiState.value = ProfileUiState.Success(user, repositories)
                }
                .onFailure { error ->
                    _uiState.value = ProfileUiState.Error(networkUtils.getErrorMessage(error))
                }
        }
    }

    fun logout() {
        viewModelScope.launch {
            githubRepository.logout()
        }
    }
}

sealed class ProfileUiState {
    object Loading : ProfileUiState()
    data class Success(val user: User, val repositories: List<Repository>) : ProfileUiState()
    data class Error(val message: String) : ProfileUiState()
}
