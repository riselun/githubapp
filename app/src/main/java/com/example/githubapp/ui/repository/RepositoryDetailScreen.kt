/**
 * Repository Detail Screen
 * Displays detailed information about a GitHub repository
 * Shows stars, forks, issues, and other repository metadata
 * 
 * @author Aaron Luo
 * @date May 7, 2025
 */
package com.example.githubapp.ui.repository

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.githubapp.data.model.Issue
import com.example.githubapp.ui.components.ErrorView
import com.example.githubapp.ui.components.LoadingIndicator

@Composable
fun RepositoryDetailScreen(
    owner: String,
    repo: String,
    onBackClick: () -> Unit,
    onCreateIssueClick: (owner: String, repo: String) -> Unit,
    viewModel: RepositoryViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val isLoggedIn by viewModel.isLoggedIn.collectAsState()
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("$owner/$repo") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    if (isLoggedIn) {
                        IconButton(onClick = { onCreateIssueClick(owner, repo) }) {
                            Icon(Icons.Default.Add, contentDescription = "Create Issue")
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        when {
            uiState.isLoading -> {
                LoadingIndicator()
            }
            uiState.error != null -> {
                ErrorView(
                    message = uiState.error!!,
                    onRetry = { viewModel.loadRepositoryDetails() }
                )
            }
            uiState.repository != null -> {
                val repository = uiState.repository!!
                
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    // Repository header
                    item {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            AsyncImage(
                                model = repository.owner.avatarUrl,
                                contentDescription = "Owner avatar",
                                modifier = Modifier
                                    .size(48.dp)
                                    .padding(end = 16.dp)
                            )
                            
                            Column {
                                Text(
                                    text = repository.fullName,
                                    style = MaterialTheme.typography.h6,
                                    fontWeight = FontWeight.Bold
                                )
                                
                                Text(
                                    text = "by ${repository.owner.username}",
                                    style = MaterialTheme.typography.caption
                                )
                            }
                        }
                    }
                    
                    // Repository description
                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        repository.description?.let {
                            Text(
                                text = it,
                                style = MaterialTheme.typography.body1,
                                modifier = Modifier.padding(bottom = 16.dp)
                            )
                        }
                    }
                    
                    // Repository stats
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            elevation = 4.dp
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                StatItem(
                                    icon = Icons.Default.Star,
                                    value = repository.stars.toString(),
                                    label = "Stars"
                                )
                                
                                StatItem(
                                    icon = Icons.Default.CallSplit,
                                    value = repository.forks.toString(),
                                    label = "Forks"
                                )
                                
                                StatItem(
                                    icon = Icons.Default.BugReport,
                                    value = repository.openIssues.toString(),
                                    label = "Issues"
                                )
                                
                                repository.language?.let {
                                    StatItem(
                                        icon = Icons.Default.Code,
                                        value = it,
                                        label = "Language"
                                    )
                                }
                            }
                        }
                    }
                    
                    // Issues section
                    if (uiState.issues.isNotEmpty()) {
                        item {
                            Spacer(modifier = Modifier.height(16.dp))
                            
                            Text(
                                text = "Open Issues",
                                style = MaterialTheme.typography.h6,
                                modifier = Modifier.padding(vertical = 8.dp)
                            )
                        }
                        
                        items(uiState.issues) { issue ->
                            IssueItem(issue = issue)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun StatItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    value: String,
    label: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            modifier = Modifier.size(24.dp)
        )
        
        Text(
            text = value,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold
        )
        
        Text(
            text = label,
            style = MaterialTheme.typography.caption
        )
    }
}

@Composable
fun IssueItem(issue: Issue) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = 2.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.BugReport,
                    contentDescription = "Issue",
                    modifier = Modifier
                        .size(16.dp)
                        .padding(end = 4.dp)
                )
                
                Text(
                    text = "#${issue.number}",
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(end = 8.dp)
                )
                
                Text(
                    text = issue.title,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            
            Spacer(modifier = Modifier.height(4.dp))
            
            issue.body?.let {
                if (it.isNotBlank()) {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.body2,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(4.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Opened by ${issue.user.username}",
                    style = MaterialTheme.typography.caption
                )
                
                Text(
                    text = "Comments: ${issue.comments}",
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}
