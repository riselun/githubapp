package com.example.githubapp.data.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\fH\u00c6\u0003J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\bH\u00c6\u0003J\t\u0010\'\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\fH\u00c6\u0003J\t\u0010*\u001a\u00020\fH\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J{\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00100\u001a\u00020\fH\u00d6\u0001J\t\u00101\u001a\u00020\u0005H\u00d6\u0001R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0016\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0016\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013\u00a8\u00062"}, d2 = {"Lcom/example/githubapp/data/model/Repository;", "", "id", "", "name", "", "fullName", "owner", "Lcom/example/githubapp/data/model/User;", "htmlUrl", "description", "stars", "", "forks", "language", "openIssues", "updatedAt", "(JLjava/lang/String;Ljava/lang/String;Lcom/example/githubapp/data/model/User;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ILjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getForks", "()I", "getFullName", "getHtmlUrl", "getId", "()J", "getLanguage", "getName", "getOpenIssues", "getOwner", "()Lcom/example/githubapp/data/model/User;", "getStars", "getUpdatedAt", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class Repository {
    @com.google.gson.annotations.SerializedName(value = "id")
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "name")
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "full_name")
    private final java.lang.String fullName = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "owner")
    private final com.example.githubapp.data.model.User owner = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "html_url")
    private final java.lang.String htmlUrl = null;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "description")
    private final java.lang.String description = null;
    @com.google.gson.annotations.SerializedName(value = "stargazers_count")
    private final int stars = 0;
    @com.google.gson.annotations.SerializedName(value = "forks_count")
    private final int forks = 0;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "language")
    private final java.lang.String language = null;
    @com.google.gson.annotations.SerializedName(value = "open_issues_count")
    private final int openIssues = 0;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "updated_at")
    private final java.lang.String updatedAt = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.example.githubapp.data.model.Repository copy(long id, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String fullName, @org.jetbrains.annotations.NotNull
    com.example.githubapp.data.model.User owner, @org.jetbrains.annotations.NotNull
    java.lang.String htmlUrl, @org.jetbrains.annotations.Nullable
    java.lang.String description, int stars, int forks, @org.jetbrains.annotations.Nullable
    java.lang.String language, int openIssues, @org.jetbrains.annotations.NotNull
    java.lang.String updatedAt) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public Repository(long id, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String fullName, @org.jetbrains.annotations.NotNull
    com.example.githubapp.data.model.User owner, @org.jetbrains.annotations.NotNull
    java.lang.String htmlUrl, @org.jetbrains.annotations.Nullable
    java.lang.String description, int stars, int forks, @org.jetbrains.annotations.Nullable
    java.lang.String language, int openIssues, @org.jetbrains.annotations.NotNull
    java.lang.String updatedAt) {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFullName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.githubapp.data.model.User component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.githubapp.data.model.User getOwner() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getHtmlUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final int component7() {
        return 0;
    }
    
    public final int getStars() {
        return 0;
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int getForks() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLanguage() {
        return null;
    }
    
    public final int component10() {
        return 0;
    }
    
    public final int getOpenIssues() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUpdatedAt() {
        return null;
    }
}