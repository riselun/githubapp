/**
 * Main Activity for the GitHub App
 * 
 * @author Aaron Luo
 * @date May 7, 2025
 */
package com.example.githubapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.githubapp.ui.components.WithNetworkStatusBanner
import com.example.githubapp.ui.navigation.AppNavHost
import com.example.githubapp.ui.theme.GitHubAppTheme
import com.example.githubapp.util.NetworkConnectivityMonitor
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    @Inject
    lateinit var networkConnectivityMonitor: NetworkConnectivityMonitor
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContent()
        }
    }
    
    /**
     * Default app content - can be overridden in tests
     */
    @Composable
    fun AppContent() {
        GitHubAppTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                GitHubApp(networkConnectivityMonitor)
            }
        }
    }
}

@Composable
fun GitHubApp(networkConnectivityMonitor: NetworkConnectivityMonitor) {
    val navController = rememberNavController()
    
    WithNetworkStatusBanner(networkConnectivityMonitor = networkConnectivityMonitor) {
        AppNavHost(navController = navController)
    }
}
