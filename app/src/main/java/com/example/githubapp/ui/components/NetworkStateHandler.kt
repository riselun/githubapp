package com.example.githubapp.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.githubapp.util.NetworkConnectivityMonitor

/**
 * A composable that displays a banner when the network is unavailable.
 * The banner will animate in and out based on the network state.
 *
 * @param networkConnectivityMonitor The network connectivity monitor to observe network state
 * @param modifier The modifier to be applied to the banner
 */
@Composable
fun NetworkStatusBanner(
    networkConnectivityMonitor: NetworkConnectivityMonitor,
    modifier: Modifier = Modifier
) {
    val isNetworkAvailable by networkConnectivityMonitor.isNetworkAvailable.collectAsState(initial = true)
    
    AnimatedVisibility(
        visible = !isNetworkAvailable,
        enter = expandVertically(),
        exit = shrinkVertically()
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.error)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "No internet connection. Some features may be unavailable.",
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}

/**
 * A composable that wraps content and shows a network status banner when the network is unavailable.
 *
 * @param networkConnectivityMonitor The network connectivity monitor to observe network state
 * @param content The content to be displayed
 */
@Composable
fun WithNetworkStatusBanner(
    networkConnectivityMonitor: NetworkConnectivityMonitor,
    content: @Composable () -> Unit
) {
    Box {
        content()
        NetworkStatusBanner(
            networkConnectivityMonitor = networkConnectivityMonitor,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}
