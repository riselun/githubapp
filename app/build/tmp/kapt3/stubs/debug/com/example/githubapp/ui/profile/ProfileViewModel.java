package com.example.githubapp.ui.profile;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u0013\u001a\u00020\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/example/githubapp/ui/profile/ProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "githubRepository", "Lcom/example/githubapp/data/repository/GithubRepository;", "networkUtils", "Lcom/example/githubapp/util/NetworkUtils;", "(Lcom/example/githubapp/data/repository/GithubRepository;Lcom/example/githubapp/util/NetworkUtils;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/githubapp/ui/profile/ProfileUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadUserProfile", "", "loadUserRepositories", "user", "Lcom/example/githubapp/data/model/User;", "logout", "app_debug"})
public final class ProfileViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.githubapp.data.repository.GithubRepository githubRepository = null;
    private final com.example.githubapp.util.NetworkUtils networkUtils = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.githubapp.ui.profile.ProfileUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.githubapp.ui.profile.ProfileUiState> uiState = null;
    
    @javax.inject.Inject
    public ProfileViewModel(@org.jetbrains.annotations.NotNull
    com.example.githubapp.data.repository.GithubRepository githubRepository, @org.jetbrains.annotations.NotNull
    com.example.githubapp.util.NetworkUtils networkUtils) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.githubapp.ui.profile.ProfileUiState> getUiState() {
        return null;
    }
    
    public final void loadUserProfile() {
    }
    
    private final void loadUserRepositories(com.example.githubapp.data.model.User user) {
    }
    
    public final void logout() {
    }
}