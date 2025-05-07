package com.example.githubapp.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapp.data.repository.GithubRepository
import com.example.githubapp.util.NetworkUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val githubRepository: GithubRepository,
    private val networkUtils: NetworkUtils
) : ViewModel() {

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Initial)
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun login(token: String) {
        if (token.isBlank()) {
            _uiState.value = LoginUiState.Error("Token cannot be empty")
            return
        }

        viewModelScope.launch {
            _uiState.value = LoginUiState.Loading

            githubRepository.login(token)
                .onSuccess { user ->
                    _uiState.value = LoginUiState.Success(user.username)
                }
                .onFailure { error ->
                    _uiState.value = LoginUiState.Error(networkUtils.getErrorMessage(error))
                }
        }
    }
}

sealed class LoginUiState {
    object Initial : LoginUiState()
    object Loading : LoginUiState()
    data class Success(val username: String) : LoginUiState()
    data class Error(val message: String) : LoginUiState()
}
