package com.example.githubapp.ui.issue

import androidx.lifecycle.SavedStateHandle
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
class IssueViewModel @Inject constructor(
    private val githubRepository: GithubRepository,
    private val networkUtils: NetworkUtils,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val owner: String = checkNotNull(savedStateHandle["owner"])
    private val repo: String = checkNotNull(savedStateHandle["repo"])

    private val _uiState = MutableStateFlow<IssueUiState>(IssueUiState.Initial)
    val uiState: StateFlow<IssueUiState> = _uiState.asStateFlow()

    fun createIssue(title: String, body: String) {
        if (title.isBlank()) {
            _uiState.value = IssueUiState.Error("Title cannot be empty")
            return
        }

        viewModelScope.launch {
            _uiState.value = IssueUiState.Loading

            githubRepository.createIssue(owner, repo, title, body)
                .onSuccess { issue ->
                    _uiState.value = IssueUiState.Success(issue.number)
                }
                .onFailure { error ->
                    _uiState.value = IssueUiState.Error(networkUtils.getErrorMessage(error))
                }
        }
    }
}

sealed class IssueUiState {
    object Initial : IssueUiState()
    object Loading : IssueUiState()
    data class Success(val issueNumber: Long) : IssueUiState()
    data class Error(val message: String) : IssueUiState()
}
