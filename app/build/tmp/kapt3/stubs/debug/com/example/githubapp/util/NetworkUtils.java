package com.example.githubapp.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/githubapp/util/NetworkUtils;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getErrorMessage", "", "throwable", "", "isNetworkAvailable", "", "app_debug"})
@javax.inject.Singleton
public final class NetworkUtils {
    private final android.content.Context context = null;
    
    @javax.inject.Inject
    public NetworkUtils(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        super();
    }
    
    public final boolean isNetworkAvailable() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getErrorMessage(@org.jetbrains.annotations.NotNull
    java.lang.Throwable throwable) {
        return null;
    }
}