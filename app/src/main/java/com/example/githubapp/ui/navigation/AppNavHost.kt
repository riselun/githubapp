package com.example.githubapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.githubapp.ui.home.HomeScreen
import com.example.githubapp.ui.login.LoginScreen
import com.example.githubapp.ui.profile.ProfileScreen
import com.example.githubapp.ui.repository.RepositoryDetailScreen
import com.example.githubapp.ui.search.SearchScreen
import com.example.githubapp.ui.issue.CreateIssueScreen

object Destinations {
    const val HOME_ROUTE = "home"
    const val SEARCH_ROUTE = "search"
    const val REPOSITORY_DETAIL_ROUTE = "repository/{owner}/{repo}"
    const val LOGIN_ROUTE = "login"
    const val PROFILE_ROUTE = "profile"
    const val CREATE_ISSUE_ROUTE = "create_issue/{owner}/{repo}"
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Destinations.HOME_ROUTE
    ) {
        composable(Destinations.HOME_ROUTE) {
            HomeScreen(
                onRepositoryClick = { owner, repo ->
                    navController.navigate("repository/$owner/$repo")
                },
                onSearchClick = {
                    navController.navigate(Destinations.SEARCH_ROUTE)
                },
                onLoginClick = {
                    navController.navigate(Destinations.LOGIN_ROUTE)
                },
                onProfileClick = {
                    navController.navigate(Destinations.PROFILE_ROUTE)
                }
            )
        }
        
        composable(Destinations.SEARCH_ROUTE) {
            SearchScreen(
                onRepositoryClick = { owner, repo ->
                    navController.navigate("repository/$owner/$repo")
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(Destinations.REPOSITORY_DETAIL_ROUTE) { backStackEntry ->
            val owner = backStackEntry.arguments?.getString("owner") ?: ""
            val repo = backStackEntry.arguments?.getString("repo") ?: ""
            RepositoryDetailScreen(
                owner = owner,
                repo = repo,
                onBackClick = {
                    navController.popBackStack()
                },
                onCreateIssueClick = { owner, repo ->
                    navController.navigate("create_issue/$owner/$repo")
                }
            )
        }
        
        composable(Destinations.LOGIN_ROUTE) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Destinations.PROFILE_ROUTE) {
                        popUpTo(Destinations.HOME_ROUTE)
                    }
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(Destinations.PROFILE_ROUTE) {
            ProfileScreen(
                onRepositoryClick = { owner, repo ->
                    navController.navigate("repository/$owner/$repo")
                },
                onBackClick = {
                    navController.popBackStack()
                },
                onLogoutClick = {
                    navController.navigate(Destinations.HOME_ROUTE) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }
        
        composable(Destinations.CREATE_ISSUE_ROUTE) { backStackEntry ->
            val owner = backStackEntry.arguments?.getString("owner") ?: ""
            val repo = backStackEntry.arguments?.getString("repo") ?: ""
            CreateIssueScreen(
                owner = owner,
                repo = repo,
                onBackClick = {
                    navController.popBackStack()
                },
                onIssueCreated = {
                    navController.popBackStack()
                }
            )
        }
    }
}
