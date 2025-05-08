/**
 * Login Screen for GitHub authentication
 * Allows users to enter their GitHub Personal Access Token
 * 
 * @author Aaron Luo
 * @date May 7, 2025
 */
package com.example.githubapp.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.res.stringResource
import com.example.githubapp.R
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.githubapp.ui.components.LoadingIndicator

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onBackClick: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    var token by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.login_to_github)) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = stringResource(R.string.go_back))
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
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.enter_token),
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                Text(
                    text = stringResource(R.string.token_help),
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
                
                OutlinedTextField(
                    value = token,
                    onValueChange = { token = it },
                    label = { Text(stringResource(R.string.personal_access_token)) },
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                imageVector = if (passwordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                                contentDescription = if (passwordVisible) stringResource(R.string.hide_token) else stringResource(R.string.show_token)
                            )
                        }
                    },
                    singleLine = true
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Button(
                    onClick = { viewModel.login(token) },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = token.isNotBlank() && uiState !is LoginUiState.Loading
                ) {
                    Text(stringResource(R.string.login))
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Text(
                    text = stringResource(R.string.token_help),
                    style = MaterialTheme.typography.caption,
                    textAlign = TextAlign.Center
                )
                
                when (val state = uiState) {
                    is LoginUiState.Error -> {
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = state.message,
                            color = MaterialTheme.colors.error,
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.Center
                        )
                    }
                    is LoginUiState.Success -> {
                        LaunchedEffect(state) {
                            onLoginSuccess()
                        }
                    }
                    else -> {}
                }
            }
            
            if (uiState is LoginUiState.Loading) {
                LoadingIndicator()
            }
        }
    }
}
