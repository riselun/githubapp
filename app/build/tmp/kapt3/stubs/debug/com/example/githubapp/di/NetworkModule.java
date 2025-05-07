package com.example.githubapp.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007\u00a8\u0006\n"}, d2 = {"Lcom/example/githubapp/di/NetworkModule;", "", "()V", "provideGithubApi", "Lcom/example/githubapp/data/api/GithubApi;", "apiClient", "Lcom/example/githubapp/data/api/GithubApiClient;", "provideGithubApiClient", "authTokenProvider", "Lcom/example/githubapp/data/api/AuthTokenProvider;", "app_debug"})
@dagger.Module
public final class NetworkModule {
    @org.jetbrains.annotations.NotNull
    public static final com.example.githubapp.di.NetworkModule INSTANCE = null;
    
    private NetworkModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.example.githubapp.data.api.GithubApiClient provideGithubApiClient(@org.jetbrains.annotations.NotNull
    com.example.githubapp.data.api.AuthTokenProvider authTokenProvider) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.example.githubapp.data.api.GithubApi provideGithubApi(@org.jetbrains.annotations.NotNull
    com.example.githubapp.data.api.GithubApiClient apiClient) {
        return null;
    }
}