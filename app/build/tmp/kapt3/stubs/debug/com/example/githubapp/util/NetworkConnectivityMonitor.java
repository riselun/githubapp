package com.example.githubapp.util;

import java.lang.System;

/**
 * A utility class that monitors network connectivity changes and provides a Flow of network state.
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/example/githubapp/util/NetworkConnectivityMonitor;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isNetworkAvailable", "Lkotlinx/coroutines/flow/Flow;", "", "()Lkotlinx/coroutines/flow/Flow;", "isCurrentlyConnected", "connectivityManager", "Landroid/net/ConnectivityManager;", "app_debug"})
@javax.inject.Singleton
public final class NetworkConnectivityMonitor {
    private final android.content.Context context = null;
    
    /**
     * Returns a Flow that emits the current network connectivity state.
     * The Flow will emit a new value whenever the network state changes.
     */
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.Boolean> isNetworkAvailable = null;
    
    @javax.inject.Inject
    public NetworkConnectivityMonitor(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> isNetworkAvailable() {
        return null;
    }
    
    /**
     * Checks if the device is currently connected to the internet.
     */
    private final boolean isCurrentlyConnected(android.net.ConnectivityManager connectivityManager) {
        return false;
    }
}