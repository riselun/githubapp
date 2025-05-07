package com.example.githubapp.util;

import java.lang.System;

/**
 * Represents the state of a paginated list.
 *
 * @param T The type of items in the list
 * @param items The current list of items
 * @param isLoading Whether a loading operation is in progress
 * @param endReached Whether the end of the list has been reached
 * @param error Any error that occurred during loading
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B5\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u00c6\u0003J?\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\tH\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001b"}, d2 = {"Lcom/example/githubapp/util/PaginatedListState;", "T", "", "items", "", "isLoading", "", "endReached", "error", "", "(Ljava/util/List;ZZLjava/lang/String;)V", "getEndReached", "()Z", "getError", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class PaginatedListState<T extends java.lang.Object> {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<T> items = null;
    private final boolean isLoading = false;
    private final boolean endReached = false;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String error = null;
    
    /**
     * Represents the state of a paginated list.
     *
     * @param T The type of items in the list
     * @param items The current list of items
     * @param isLoading Whether a loading operation is in progress
     * @param endReached Whether the end of the list has been reached
     * @param error Any error that occurred during loading
     */
    @org.jetbrains.annotations.NotNull
    public final com.example.githubapp.util.PaginatedListState<T> copy(@org.jetbrains.annotations.NotNull
    java.util.List<? extends T> items, boolean isLoading, boolean endReached, @org.jetbrains.annotations.Nullable
    java.lang.String error) {
        return null;
    }
    
    /**
     * Represents the state of a paginated list.
     *
     * @param T The type of items in the list
     * @param items The current list of items
     * @param isLoading Whether a loading operation is in progress
     * @param endReached Whether the end of the list has been reached
     * @param error Any error that occurred during loading
     */
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Represents the state of a paginated list.
     *
     * @param T The type of items in the list
     * @param items The current list of items
     * @param isLoading Whether a loading operation is in progress
     * @param endReached Whether the end of the list has been reached
     * @param error Any error that occurred during loading
     */
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    /**
     * Represents the state of a paginated list.
     *
     * @param T The type of items in the list
     * @param items The current list of items
     * @param isLoading Whether a loading operation is in progress
     * @param endReached Whether the end of the list has been reached
     * @param error Any error that occurred during loading
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public PaginatedListState() {
        super();
    }
    
    public PaginatedListState(@org.jetbrains.annotations.NotNull
    java.util.List<? extends T> items, boolean isLoading, boolean endReached, @org.jetbrains.annotations.Nullable
    java.lang.String error) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<T> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<T> getItems() {
        return null;
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean getEndReached() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getError() {
        return null;
    }
}