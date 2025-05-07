/**
 * Home Screen
 * Displays trending GitHub repositories and navigation options
 * 
 * @author Aaron Luo
 * @date May 7, 2025
 */
package com.example.githubapp.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.githubapp.ui.components.ErrorView
import com.example.githubapp.ui.components.LoadingIndicator
import com.example.githubapp.ui.components.RepositoryItem

@Composable
fun HomeScreen(
    onRepositoryClick: (owner: String, repo: String) -> Unit,
    onSearchClick: () -> Unit,
    onLoginClick: () -> Unit,
    onProfileClick: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val isLoggedIn by viewModel.isLoggedIn.collectAsState()
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("GitHub Explorer") },
                actions = {
                    IconButton(onClick = onSearchClick) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                    
                    IconButton(
                        onClick = if (isLoggedIn) onProfileClick else onLoginClick
                    ) {
                        Icon(Icons.Default.Person, contentDescription = if (isLoggedIn) "Profile" else "Login")
                    }
                }
            )
        }
    ) { paddingValues ->
        when (val state = uiState) {
            is HomeUiState.Loading -> {
                LoadingIndicator()
            }
            is HomeUiState.Success -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    item {
                        Text(
                            text = "Trending Repositories",
                            style = MaterialTheme.typography.h5,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                    
                    items(state.repositories) { repository ->
                        RepositoryItem(
                            repository = repository,
                            onClick = {
                                onRepositoryClick(repository.owner.username, repository.name)
                            }
                        )
                    }
                }
            }
            is HomeUiState.Error -> {
                ErrorView(
                    message = state.message,
                    onRetry = { viewModel.loadTrendingRepositories() }
                )
            }
        }
    }
}
