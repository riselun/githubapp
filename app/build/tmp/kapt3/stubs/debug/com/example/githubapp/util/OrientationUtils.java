package com.example.githubapp.util;

import java.lang.System;

/**
 * Utility class for handling orientation-related functionality
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/githubapp/util/OrientationUtils;", "", "()V", "isLandscape", "", "context", "Landroid/content/Context;", "app_debug"})
public final class OrientationUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.example.githubapp.util.OrientationUtils INSTANCE = null;
    
    private OrientationUtils() {
        super();
    }
    
    /**
     * Check if the device is in landscape orientation
     *
     * @param context The application context
     * @return True if the device is in landscape orientation, false otherwise
     */
    public final boolean isLandscape(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return false;
    }
    
    /**
     * Composable function to check if the device is in landscape orientation
     *
     * @return True if the device is in landscape orientation, false otherwise
     */
    @androidx.compose.runtime.Composable
    public final boolean isLandscape() {
        return false;
    }
}