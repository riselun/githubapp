package com.example.githubapp.ui.issue

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.githubapp.ui.components.LoadingIndicator

@Composable
fun CreateIssueScreen(
    owner: String,
    repo: String,
    onBackClick: () -> Unit,
    onIssueCreated: () -> Unit,
    viewModel: IssueViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    var title by remember { mutableStateOf("") }
    var body by remember { mutableStateOf("") }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Create Issue") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Creating issue for $owner/$repo",
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Title") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                OutlinedTextField(
                    value = body,
                    onValueChange = { body = it },
                    label = { Text("Description") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    maxLines = 10
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Button(
                    onClick = { viewModel.createIssue(title, body) },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = title.isNotBlank() && uiState !is IssueUiState.Loading
                ) {
                    Text("Submit Issue")
                }
                
                when (val state = uiState) {
                    is IssueUiState.Error -> {
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = state.message,
                            color = MaterialTheme.colors.error,
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    is IssueUiState.Success -> {
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Issue #${state.issueNumber} created successfully!",
                            color = MaterialTheme.colors.primary,
                            style = MaterialTheme.typography.body1,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        Button(
                            onClick = onIssueCreated,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Go Back")
                        }
                    }
                    else -> {}
                }
            }
            
            if (uiState is IssueUiState.Loading) {
                LoadingIndicator()
            }
        }
    }
}
