package com.example.githubapp.ui.repository;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/example/githubapp/ui/repository/RepositoryViewModel;", "Landroidx/lifecycle/ViewModel;", "githubRepository", "Lcom/example/githubapp/data/repository/GithubRepository;", "networkUtils", "Lcom/example/githubapp/util/NetworkUtils;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Lcom/example/githubapp/data/repository/GithubRepository;Lcom/example/githubapp/util/NetworkUtils;Landroidx/lifecycle/SavedStateHandle;)V", "_isLoggedIn", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_uiState", "Lcom/example/githubapp/ui/repository/RepositoryUiState;", "isLoggedIn", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "owner", "", "repo", "uiState", "getUiState", "loadRepositoryDetails", "", "loadRepositoryIssues", "observeLoginState", "app_debug"})
public final class RepositoryViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.githubapp.data.repository.GithubRepository githubRepository = null;
    private final com.example.githubapp.util.NetworkUtils networkUtils = null;
    private final java.lang.String owner = null;
    private final java.lang.String repo = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.githubapp.ui.repository.RepositoryUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.githubapp.ui.repository.RepositoryUiState> uiState = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoggedIn = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoggedIn = null;
    
    @javax.inject.Inject
    public RepositoryViewModel(@org.jetbrains.annotations.NotNull
    com.example.githubapp.data.repository.GithubRepository githubRepository, @org.jetbrains.annotations.NotNull
    com.example.githubapp.util.NetworkUtils networkUtils, @org.jetbrains.annotations.NotNull
    androidx.lifecycle.SavedStateHandle savedStateHandle) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.githubapp.ui.repository.RepositoryUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoggedIn() {
        return null;
    }
    
    private final void observeLoginState() {
    }
    
    public final void loadRepositoryDetails() {
    }
    
    private final void loadRepositoryIssues() {
    }
}