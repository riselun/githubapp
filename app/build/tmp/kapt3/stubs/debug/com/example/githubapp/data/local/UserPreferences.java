package com.example.githubapp.data.local;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u000f\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0019\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/example/githubapp/data/local/UserPreferences;", "Lcom/example/githubapp/data/api/AuthTokenProvider;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "authToken", "Lkotlinx/coroutines/flow/Flow;", "", "getAuthToken", "()Lkotlinx/coroutines/flow/Flow;", "authTokenKey", "Landroidx/datastore/preferences/core/Preferences$Key;", "username", "getUsername", "usernameKey", "clearUserData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveAuthToken", "token", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveUsername", "app_debug"})
@javax.inject.Singleton
public final class UserPreferences implements com.example.githubapp.data.api.AuthTokenProvider {
    private final android.content.Context context = null;
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> authTokenKey = null;
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> usernameKey = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.String> authToken = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.String> username = null;
    
    @javax.inject.Inject
    public UserPreferences(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getAuthToken() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getUsername() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveAuthToken(@org.jetbrains.annotations.NotNull
    java.lang.String token, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveUsername(@org.jetbrains.annotations.NotNull
    java.lang.String username, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object clearUserData(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * Gets the current auth token synchronously
     * Note: This blocks the current thread to get the value from DataStore
     * This is only used by the AuthInterceptor and should be used carefully
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String getAuthToken() {
        return null;
    }
}