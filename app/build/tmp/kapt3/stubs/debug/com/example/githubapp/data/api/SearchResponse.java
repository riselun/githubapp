package com.example.githubapp.data.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0006H\u00c6\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u00c6\u0003J3\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0019"}, d2 = {"Lcom/example/githubapp/data/api/SearchResponse;", "T", "", "total_count", "", "incomplete_results", "", "items", "", "(IZLjava/util/List;)V", "getIncomplete_results", "()Z", "getItems", "()Ljava/util/List;", "getTotal_count", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "app_debug"})
public final class SearchResponse<T extends java.lang.Object> {
    private final int total_count = 0;
    private final boolean incomplete_results = false;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<T> items = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.example.githubapp.data.api.SearchResponse<T> copy(int total_count, boolean incomplete_results, @org.jetbrains.annotations.NotNull
    java.util.List<? extends T> items) {
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
    
    public SearchResponse(int total_count, boolean incomplete_results, @org.jetbrains.annotations.NotNull
    java.util.List<? extends T> items) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getTotal_count() {
        return 0;
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final boolean getIncomplete_results() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<T> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<T> getItems() {
        return null;
    }
}