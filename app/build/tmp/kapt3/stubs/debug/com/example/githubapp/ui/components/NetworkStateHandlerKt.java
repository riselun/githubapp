package com.example.githubapp.ui.components;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a#\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\b\u00a2\u0006\u0002\b\tH\u0007\u00a8\u0006\n"}, d2 = {"NetworkStatusBanner", "", "networkConnectivityMonitor", "Lcom/example/githubapp/util/NetworkConnectivityMonitor;", "modifier", "Landroidx/compose/ui/Modifier;", "WithNetworkStatusBanner", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "app_debug"})
public final class NetworkStateHandlerKt {
    
    /**
     * A composable that displays a banner when the network is unavailable.
     * The banner will animate in and out based on the network state.
     *
     * @param networkConnectivityMonitor The network connectivity monitor to observe network state
     * @param modifier The modifier to be applied to the banner
     */
    @androidx.compose.runtime.Composable
    public static final void NetworkStatusBanner(@org.jetbrains.annotations.NotNull
    com.example.githubapp.util.NetworkConnectivityMonitor networkConnectivityMonitor, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * A composable that wraps content and shows a network status banner when the network is unavailable.
     *
     * @param networkConnectivityMonitor The network connectivity monitor to observe network state
     * @param content The content to be displayed
     */
    @androidx.compose.runtime.Composable
    public static final void WithNetworkStatusBanner(@org.jetbrains.annotations.NotNull
    com.example.githubapp.util.NetworkConnectivityMonitor networkConnectivityMonitor, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> content) {
    }
}