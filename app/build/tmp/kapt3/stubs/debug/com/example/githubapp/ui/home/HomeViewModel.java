package com.example.githubapp.ui.home;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0012H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/example/githubapp/ui/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "githubRepository", "Lcom/example/githubapp/data/repository/GithubRepository;", "networkUtils", "Lcom/example/githubapp/util/NetworkUtils;", "(Lcom/example/githubapp/data/repository/GithubRepository;Lcom/example/githubapp/util/NetworkUtils;)V", "_isLoggedIn", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_uiState", "Lcom/example/githubapp/ui/home/HomeUiState;", "isLoggedIn", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "uiState", "getUiState", "loadTrendingRepositories", "", "observeLoginState", "app_debug"})
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.githubapp.data.repository.GithubRepository githubRepository = null;
    private final com.example.githubapp.util.NetworkUtils networkUtils = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.githubapp.ui.home.HomeUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.githubapp.ui.home.HomeUiState> uiState = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoggedIn = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoggedIn = null;
    
    @javax.inject.Inject
    public HomeViewModel(@org.jetbrains.annotations.NotNull
    com.example.githubapp.data.repository.GithubRepository githubRepository, @org.jetbrains.annotations.NotNull
    com.example.githubapp.util.NetworkUtils networkUtils) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.githubapp.ui.home.HomeUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoggedIn() {
        return null;
    }
    
    private final void observeLoginState() {
    }
    
    public final void loadTrendingRepositories() {
    }
}