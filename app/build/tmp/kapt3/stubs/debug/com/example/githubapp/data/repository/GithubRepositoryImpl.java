package com.example.githubapp.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006JB\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J2\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018JH\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ8\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u001a0\f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b!\u0010\"J\"\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\fH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b%\u0010&J8\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u001a0\f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b(\u0010\"J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0016J*\u0010,\u001a\b\u0012\u0004\u0012\u00020$0\f2\u0006\u0010-\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b.\u0010/J\u0011\u00100\u001a\u000201H\u0096@\u00f8\u0001\u0002\u00a2\u0006\u0002\u0010&JJ\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u001a0\f2\u0006\u00103\u001a\u00020\u000f2\b\u00104\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b5\u0010\u001fR\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u00066"}, d2 = {"Lcom/example/githubapp/data/repository/GithubRepositoryImpl;", "Lcom/example/githubapp/data/repository/GithubRepository;", "apiClient", "Lcom/example/githubapp/data/api/GithubApiClient;", "userPreferences", "Lcom/example/githubapp/data/local/UserPreferences;", "(Lcom/example/githubapp/data/api/GithubApiClient;Lcom/example/githubapp/data/local/UserPreferences;)V", "api", "Lcom/example/githubapp/data/api/GithubApi;", "getApi", "()Lcom/example/githubapp/data/api/GithubApi;", "createIssue", "Lkotlin/Result;", "Lcom/example/githubapp/data/model/Issue;", "owner", "", "repo", "title", "body", "createIssue-yxL6bBk", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRepository", "Lcom/example/githubapp/data/model/Repository;", "getRepository-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRepositoryIssues", "", "page", "", "perPage", "getRepositoryIssues-yxL6bBk", "(Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTrendingRepositories", "getTrendingRepositories-0E7RQCE", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserProfile", "Lcom/example/githubapp/data/model/User;", "getUserProfile-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserRepositories", "getUserRepositories-0E7RQCE", "isLoggedIn", "Lkotlinx/coroutines/flow/Flow;", "", "login", "token", "login-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "", "searchRepositories", "query", "language", "searchRepositories-yxL6bBk", "app_debug"})
@javax.inject.Singleton
public final class GithubRepositoryImpl implements com.example.githubapp.data.repository.GithubRepository {
    private final com.example.githubapp.data.api.GithubApiClient apiClient = null;
    private final com.example.githubapp.data.local.UserPreferences userPreferences = null;
    
    @javax.inject.Inject
    public GithubRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.example.githubapp.data.api.GithubApiClient apiClient, @org.jetbrains.annotations.NotNull
    com.example.githubapp.data.local.UserPreferences userPreferences) {
        super();
    }
    
    private final com.example.githubapp.data.api.GithubApi getApi() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object logout(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlinx.coroutines.flow.Flow<java.lang.Boolean> isLoggedIn() {
        return null;
    }
}