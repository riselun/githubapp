package com.example.githubapp.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\'\u00a8\u0006\u000b"}, d2 = {"Lcom/example/githubapp/di/AppModule;", "", "()V", "bindAuthTokenProvider", "Lcom/example/githubapp/data/api/AuthTokenProvider;", "userPreferences", "Lcom/example/githubapp/data/local/UserPreferences;", "bindGithubRepository", "Lcom/example/githubapp/data/repository/GithubRepository;", "githubRepositoryImpl", "Lcom/example/githubapp/data/repository/GithubRepositoryImpl;", "app_debug"})
@dagger.Module
public abstract class AppModule {
    
    public AppModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Binds
    public abstract com.example.githubapp.data.repository.GithubRepository bindGithubRepository(@org.jetbrains.annotations.NotNull
    com.example.githubapp.data.repository.GithubRepositoryImpl githubRepositoryImpl);
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Binds
    public abstract com.example.githubapp.data.api.AuthTokenProvider bindAuthTokenProvider(@org.jetbrains.annotations.NotNull
    com.example.githubapp.data.local.UserPreferences userPreferences);
}