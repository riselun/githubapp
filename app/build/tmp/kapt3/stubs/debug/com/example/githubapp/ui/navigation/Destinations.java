package com.example.githubapp.ui.navigation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/githubapp/ui/navigation/Destinations;", "", "()V", "CREATE_ISSUE_ROUTE", "", "HOME_ROUTE", "LOGIN_ROUTE", "PROFILE_ROUTE", "REPOSITORY_DETAIL_ROUTE", "SEARCH_ROUTE", "app_debug"})
public final class Destinations {
    @org.jetbrains.annotations.NotNull
    public static final com.example.githubapp.ui.navigation.Destinations INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String HOME_ROUTE = "home";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SEARCH_ROUTE = "search";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String REPOSITORY_DETAIL_ROUTE = "repository/{owner}/{repo}";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String LOGIN_ROUTE = "login";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String PROFILE_ROUTE = "profile";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CREATE_ISSUE_ROUTE = "create_issue/{owner}/{repo}";
    
    private Destinations() {
        super();
    }
}