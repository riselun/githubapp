package com.example.githubapp.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/githubapp/util/Constants;", "", "()V", "GITHUB_API_BASE_URL", "", "GITHUB_WEB_URL", "NETWORK_ERROR_MESSAGE", "NOT_FOUND_ERROR_MESSAGE", "PREFS_NAME", "SERVER_ERROR_MESSAGE", "UNAUTHORIZED_ERROR_MESSAGE", "app_debug"})
public final class Constants {
    @org.jetbrains.annotations.NotNull
    public static final com.example.githubapp.util.Constants INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String GITHUB_API_BASE_URL = "https://api.github.com/";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String GITHUB_WEB_URL = "https://github.com/";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String NETWORK_ERROR_MESSAGE = "Network error. Please check your internet connection.";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SERVER_ERROR_MESSAGE = "Server error. Please try again later.";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String UNAUTHORIZED_ERROR_MESSAGE = "Authentication failed. Please check your credentials.";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String NOT_FOUND_ERROR_MESSAGE = "Resource not found.";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String PREFS_NAME = "github_app_prefs";
    
    private Constants() {
        super();
    }
}