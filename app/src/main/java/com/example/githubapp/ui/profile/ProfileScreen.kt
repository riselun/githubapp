package com.example.githubapp.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.githubapp.ui.components.ErrorView
import com.example.githubapp.ui.components.LoadingIndicator
import com.example.githubapp.ui.components.RepositoryItem

@Composable
fun ProfileScreen(
    onRepositoryClick: (owner: String, repo: String) -> Unit,
    onBackClick: () -> Unit,
    onLogoutClick: () -> Unit,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = {
                        viewModel.logout()
                        onLogoutClick()
                    }) {
                        Icon(Icons.Default.ExitToApp, contentDescription = "Logout")
                    }
                }
            )
        }
    ) { paddingValues ->
        when (val state = uiState) {
            is ProfileUiState.Loading -> {
                LoadingIndicator()
            }
            is ProfileUiState.Error -> {
                ErrorView(
                    message = state.message,
                    onRetry = { viewModel.loadUserProfile() }
                )
            }
            is ProfileUiState.Success -> {
                val user = state.user
                val repositories = state.repositories
                
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    // User profile header
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            AsyncImage(
                                model = user.avatarUrl,
                                contentDescription = "User avatar",
                                modifier = Modifier
                                    .size(100.dp)
                                    .padding(bottom = 16.dp)
                            )
                            
                            Text(
                                text = user.name ?: user.username,
                                style = MaterialTheme.typography.h5,
                                fontWeight = FontWeight.Bold
                            )
                            
                            Text(
                                text = "@${user.username}",
                                style = MaterialTheme.typography.subtitle1,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            
                            user.bio?.let {
                                Text(
                                    text = it,
                                    style = MaterialTheme.typography.body1,
                                    modifier = Modifier.padding(bottom = 16.dp)
                                )
                            }
                            
                            // User stats
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                UserStat(label = "Repositories", value = user.publicRepos.toString())
                                UserStat(label = "Followers", value = user.followers.toString())
                                UserStat(label = "Following", value = user.following.toString())
                            }
                            
                            Divider(modifier = Modifier.padding(vertical = 16.dp))
                        }
                    }
                    
                    // Repositories section
                    item {
                        Text(
                            text = "Repositories",
                            style = MaterialTheme.typography.h6,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                    }
                    
                    if (repositories.isEmpty()) {
                        item {
                            Text(
                                text = "No repositories found",
                                style = MaterialTheme.typography.body1,
                                modifier = Modifier.padding(vertical = 16.dp)
                            )
                        }
                    } else {
                        items(repositories) { repository ->
                            RepositoryItem(
                                repository = repository,
                                onClick = {
                                    onRepositoryClick(repository.owner.username, repository.name)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun UserStat(label: String, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold
        )
        
        Text(
            text = label,
            style = MaterialTheme.typography.caption
        )
    }
}
