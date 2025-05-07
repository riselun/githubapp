package com.example.githubapp.ui.issue;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/example/githubapp/ui/issue/IssueViewModel;", "Landroidx/lifecycle/ViewModel;", "githubRepository", "Lcom/example/githubapp/data/repository/GithubRepository;", "networkUtils", "Lcom/example/githubapp/util/NetworkUtils;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Lcom/example/githubapp/data/repository/GithubRepository;Lcom/example/githubapp/util/NetworkUtils;Landroidx/lifecycle/SavedStateHandle;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/githubapp/ui/issue/IssueUiState;", "owner", "", "repo", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "createIssue", "", "title", "body", "app_debug"})
public final class IssueViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.githubapp.data.repository.GithubRepository githubRepository = null;
    private final com.example.githubapp.util.NetworkUtils networkUtils = null;
    private final java.lang.String owner = null;
    private final java.lang.String repo = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.githubapp.ui.issue.IssueUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.githubapp.ui.issue.IssueUiState> uiState = null;
    
    @javax.inject.Inject
    public IssueViewModel(@org.jetbrains.annotations.NotNull
    com.example.githubapp.data.repository.GithubRepository githubRepository, @org.jetbrains.annotations.NotNull
    com.example.githubapp.util.NetworkUtils networkUtils, @org.jetbrains.annotations.NotNull
    androidx.lifecycle.SavedStateHandle savedStateHandle) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.githubapp.ui.issue.IssueUiState> getUiState() {
        return null;
    }
    
    public final void createIssue(@org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.lang.String body) {
    }
}