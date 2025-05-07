/**
 * Pagination utilities for handling infinite scrolling
 * Provides helper functions for implementing pagination in LazyColumn
 * 
 * @author Aaron Luo
 * @date May 7, 2025
 */
package com.example.githubapp.util

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow

/**
 * A utility class for handling pagination in Jetpack Compose.
 */
object PaginationUtils {
    
    /**
     * A composable that detects when the user has scrolled to the end of a LazyList
     * and triggers the onLoadMore callback.
     *
     * @param listState The LazyListState to observe
     * @param buffer The number of items from the end to trigger loading more
     * @param onLoadMore Callback to invoke when more items should be loaded
     */
    @Composable
    fun OnBottomReached(
        listState: LazyListState,
        buffer: Int = 2,
        onLoadMore: () -> Unit
    ) {
        val shouldLoadMore = remember {
            derivedStateOf {
                val layoutInfo = listState.layoutInfo
                val totalItemsNumber = layoutInfo.totalItemsCount
                val lastVisibleItemIndex = (layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0) + 1
                
                lastVisibleItemIndex > (totalItemsNumber - buffer)
            }
        }
        
        LaunchedEffect(shouldLoadMore) {
            snapshotFlow { shouldLoadMore.value }
                .collect { if (it) onLoadMore() }
        }
    }
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
data class PaginatedListState<T>(
    val items: List<T> = emptyList(),
    val isLoading: Boolean = false,
    val endReached: Boolean = false,
    val error: String? = null
)
