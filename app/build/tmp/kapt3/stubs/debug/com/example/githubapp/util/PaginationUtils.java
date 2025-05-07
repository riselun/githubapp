package com.example.githubapp.util;

import java.lang.System;

/**
 * A utility class for handling pagination in Jetpack Compose.
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/example/githubapp/util/PaginationUtils;", "", "()V", "OnBottomReached", "", "listState", "Landroidx/compose/foundation/lazy/LazyListState;", "buffer", "", "onLoadMore", "Lkotlin/Function0;", "app_debug"})
public final class PaginationUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.example.githubapp.util.PaginationUtils INSTANCE = null;
    
    private PaginationUtils() {
        super();
    }
    
    /**
     * A composable that detects when the user has scrolled to the end of a LazyList
     * and triggers the onLoadMore callback.
     *
     * @param listState The LazyListState to observe
     * @param buffer The number of items from the end to trigger loading more
     * @param onLoadMore Callback to invoke when more items should be loaded
     */
    @androidx.compose.runtime.Composable
    public final void OnBottomReached(@org.jetbrains.annotations.NotNull
    androidx.compose.foundation.lazy.LazyListState listState, int buffer, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onLoadMore) {
    }
}