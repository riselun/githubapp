package com.example.githubapp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/example/githubapp/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "networkConnectivityMonitor", "Lcom/example/githubapp/util/NetworkConnectivityMonitor;", "getNetworkConnectivityMonitor", "()Lcom/example/githubapp/util/NetworkConnectivityMonitor;", "setNetworkConnectivityMonitor", "(Lcom/example/githubapp/util/NetworkConnectivityMonitor;)V", "AppContent", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class MainActivity extends androidx.activity.ComponentActivity {
    @javax.inject.Inject
    public com.example.githubapp.util.NetworkConnectivityMonitor networkConnectivityMonitor;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.githubapp.util.NetworkConnectivityMonitor getNetworkConnectivityMonitor() {
        return null;
    }
    
    public final void setNetworkConnectivityMonitor(@org.jetbrains.annotations.NotNull
    com.example.githubapp.util.NetworkConnectivityMonitor p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Default app content - can be overridden in tests
     */
    @androidx.compose.runtime.Composable
    public final void AppContent() {
    }
}