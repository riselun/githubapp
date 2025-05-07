/**
 * Search Screen for GitHub repositories
 * Allows users to search repositories by name and filter by programming language
 * Implements pagination for search results
 * 
 * @author Aaron Luo
 * @date May 7, 2025
 */
package com.example.githubapp.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.githubapp.ui.components.ErrorView
import com.example.githubapp.ui.components.LoadingIndicator
import com.example.githubapp.ui.components.RepositoryItem
import com.example.githubapp.util.PaginationUtils
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SearchScreen(
    onRepositoryClick: (owner: String, repo: String) -> Unit,
    onBackClick: () -> Unit,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val selectedLanguage by viewModel.selectedLanguage.collectAsState()
    
    var showLanguageDialog by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }
    val coroutineScope = rememberCoroutineScope()
    
    LaunchedEffect(Unit) {
        delay(300) // Small delay to ensure the UI is ready
        focusRequester.requestFocus()
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TextField(
                        value = searchQuery,
                        onValueChange = { viewModel.onSearchQueryChanged(it) },
                        placeholder = { Text("Search repositories...") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .focusRequester(focusRequester),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        singleLine = true,
                        trailingIcon = {
                            if (searchQuery.isNotEmpty()) {
                                IconButton(onClick = { viewModel.onSearchQueryChanged("") }) {
                                    Icon(Icons.Default.Clear, contentDescription = "Clear")
                                }
                            }
                        }
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { showLanguageDialog = true }) {
                        Icon(Icons.Default.FilterList, contentDescription = "Filter by language")
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
            val paginatedList = uiState.paginatedList
            val listState = rememberLazyListState()
            
            // Implement pagination using the OnBottomReached composable
            PaginationUtils.OnBottomReached(listState = listState) {
                viewModel.loadMoreRepositories()
            }
            
            when {
                paginatedList.items.isEmpty() && paginatedList.isLoading -> {
                    LoadingIndicator()
                }
                paginatedList.error != null && paginatedList.items.isEmpty() -> {
                    ErrorView(
                        message = paginatedList.error!!,
                        onRetry = {
                            if (searchQuery.isNotBlank()) {
                                viewModel.onSearchQueryChanged(searchQuery)
                            }
                        }
                    )
                }
                paginatedList.items.isEmpty() && searchQuery.isNotBlank() && !paginatedList.isLoading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("No repositories found")
                    }
                }
                paginatedList.items.isNotEmpty() -> {
                    LazyColumn(
                        state = listState,
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(vertical = 8.dp)
                    ) {
                        if (selectedLanguage != null) {
                            item {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp, vertical = 8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Language: $selectedLanguage",
                                        style = MaterialTheme.typography.subtitle1,
                                        modifier = Modifier.weight(1f)
                                    )
                                    TextButton(onClick = { viewModel.onLanguageSelected(null) }) {
                                        Text("Clear")
                                    }
                                }
                            }
                        }
                        
                        items(paginatedList.items) { repository ->
                            RepositoryItem(
                                repository = repository,
                                onClick = {
                                    onRepositoryClick(repository.owner.username, repository.name)
                                }
                            )
                        }
                        
                        // Show loading indicator at the bottom while loading more items
                        if (paginatedList.isLoading && paginatedList.items.isNotEmpty()) {
                            item {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    CircularProgressIndicator(modifier = Modifier.size(32.dp))
                                }
                            }
                        }
                        
                        // Show error while loading more items
                        if (paginatedList.error != null && paginatedList.items.isNotEmpty()) {
                            item {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                        Text(
                                            text = paginatedList.error!!,
                                            color = MaterialTheme.colors.error,
                                            textAlign = TextAlign.Center
                                        )
                                        TextButton(onClick = { viewModel.loadMoreRepositories() }) {
                                            Text("Retry")
                                        }
                                    }
                                }
                            }
                        }
                        
                        // Show message when reached the end of the list
                        if (paginatedList.endReached && paginatedList.items.isNotEmpty()) {
                            item {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "No more repositories to load",
                                        style = MaterialTheme.typography.caption,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }
                }
                searchQuery.isBlank() -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Search for GitHub repositories")
                    }
                }
            }
        }
    }
    
    if (showLanguageDialog) {
        val languages = listOf("Kotlin", "Java", "Swift", "JavaScript", "Python", "Go", "Rust", "C++", "C#", "TypeScript")
        
        AlertDialog(
            onDismissRequest = { showLanguageDialog = false },
            title = { Text("Filter by language") },
            text = {
                LazyColumn {
                    items(languages) { language ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                                .clickable {
                                    viewModel.onLanguageSelected(language)
                                    showLanguageDialog = false
                                },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = language == selectedLanguage,
                                onClick = {
                                    viewModel.onLanguageSelected(language)
                                    showLanguageDialog = false
                                }
                            )
                            Text(
                                text = language,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showLanguageDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}
