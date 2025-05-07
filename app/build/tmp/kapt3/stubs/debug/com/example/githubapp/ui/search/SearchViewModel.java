package com.example.githubapp.ui.search;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\tJ\b\u0010 \u001a\u00020\u001aH\u0002J$\u0010!\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\"\u001a\u00020\u0010H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014\u00a8\u0006#"}, d2 = {"Lcom/example/githubapp/ui/search/SearchViewModel;", "Landroidx/lifecycle/ViewModel;", "githubRepository", "Lcom/example/githubapp/data/repository/GithubRepository;", "networkUtils", "Lcom/example/githubapp/util/NetworkUtils;", "(Lcom/example/githubapp/data/repository/GithubRepository;Lcom/example/githubapp/util/NetworkUtils;)V", "_searchQuery", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_selectedLanguage", "_uiState", "Lcom/example/githubapp/ui/search/SearchUiState;", "currentPage", "", "isLastPage", "", "searchQuery", "Lkotlinx/coroutines/flow/StateFlow;", "getSearchQuery", "()Lkotlinx/coroutines/flow/StateFlow;", "selectedLanguage", "getSelectedLanguage", "uiState", "getUiState", "loadMoreRepositories", "", "observeSearchQuery", "onLanguageSelected", "language", "onSearchQueryChanged", "query", "resetSearch", "searchRepositories", "isLoadingMore", "app_debug"})
public final class SearchViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.githubapp.data.repository.GithubRepository githubRepository = null;
    private final com.example.githubapp.util.NetworkUtils networkUtils = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.githubapp.ui.search.SearchUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.githubapp.ui.search.SearchUiState> uiState = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _searchQuery = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> searchQuery = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _selectedLanguage = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> selectedLanguage = null;
    private int currentPage = 1;
    private boolean isLastPage = false;
    
    @javax.inject.Inject
    public SearchViewModel(@org.jetbrains.annotations.NotNull
    com.example.githubapp.data.repository.GithubRepository githubRepository, @org.jetbrains.annotations.NotNull
    com.example.githubapp.util.NetworkUtils networkUtils) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.githubapp.ui.search.SearchUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSearchQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSelectedLanguage() {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.FlowPreview.class})
    private final void observeSearchQuery() {
    }
    
    public final void onSearchQueryChanged(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
    
    public final void onLanguageSelected(@org.jetbrains.annotations.Nullable
    java.lang.String language) {
    }
    
    public final void loadMoreRepositories() {
    }
    
    private final void resetSearch() {
    }
    
    private final void searchRepositories(java.lang.String query, java.lang.String language, boolean isLoadingMore) {
    }
}