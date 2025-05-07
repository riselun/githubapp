package com.example.githubapp.ui

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.githubapp.data.model.Repository
import com.example.githubapp.data.model.User
import com.example.githubapp.ui.home.HomeScreen
import com.example.githubapp.ui.home.HomeUiState
import com.example.githubapp.ui.home.HomeViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@HiltAndroidTest
class HomeScreenTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createComposeRule()

    private lateinit var mockViewModel: HomeViewModel

    @Before
    fun setup() {
        hiltRule.inject()
        mockViewModel = mock(HomeViewModel::class.java)
    }

    @Test
    fun homeScreen_displaysLoadingIndicator_whenStateIsLoading() {
        // Arrange
        `when`(mockViewModel.uiState).thenReturn(MutableStateFlow(HomeUiState.Loading))
        `when`(mockViewModel.isLoggedIn).thenReturn(MutableStateFlow(false))

        // Act
        composeTestRule.setContent {
            HomeScreen(
                onRepositoryClick = { _, _ -> },
                onSearchClick = {},
                onLoginClick = {},
                onProfileClick = {},
                viewModel = mockViewModel
            )
        }

        // Assert
        composeTestRule.onNodeWithContentDescription("Loading").assertExists()
    }

    @Test
    fun homeScreen_displaysRepositories_whenStateIsSuccess() {
        // Arrange
        val mockUser = User(
            username = "testuser",
            id = 1,
            avatarUrl = "https://example.com/avatar.png",
            htmlUrl = "https://github.com/testuser",
            name = "Test User",
            bio = "Test Bio",
            publicRepos = 10,
            followers = 5,
            following = 3
        )
        
        val mockRepositories = listOf(
            Repository(
                id = 1,
                name = "repo1",
                fullName = "testuser/repo1",
                owner = mockUser,
                htmlUrl = "https://github.com/testuser/repo1",
                description = "Test Repository 1",
                stars = 100,
                forks = 20,
                language = "Kotlin",
                openIssues = 5,
                updatedAt = "2023-05-01T12:00:00Z"
            )
        )
        
        `when`(mockViewModel.uiState).thenReturn(MutableStateFlow(HomeUiState.Success(mockRepositories)))
        `when`(mockViewModel.isLoggedIn).thenReturn(MutableStateFlow(false))

        // Act
        composeTestRule.setContent {
            HomeScreen(
                onRepositoryClick = { _, _ -> },
                onSearchClick = {},
                onLoginClick = {},
                onProfileClick = {},
                viewModel = mockViewModel
            )
        }

        // Assert
        composeTestRule.onNodeWithText("Trending Repositories").assertExists()
        composeTestRule.onNodeWithText("testuser/repo1").assertExists()
        composeTestRule.onNodeWithText("Test Repository 1").assertExists()
        composeTestRule.onNodeWithText("100").assertExists() // Stars count
        composeTestRule.onNodeWithText("Kotlin").assertExists() // Language
    }

    @Test
    fun homeScreen_displaysErrorView_whenStateIsError() {
        // Arrange
        val errorMessage = "Network error"
        `when`(mockViewModel.uiState).thenReturn(MutableStateFlow(HomeUiState.Error(errorMessage)))
        `when`(mockViewModel.isLoggedIn).thenReturn(MutableStateFlow(false))

        // Act
        composeTestRule.setContent {
            HomeScreen(
                onRepositoryClick = { _, _ -> },
                onSearchClick = {},
                onLoginClick = {},
                onProfileClick = {},
                viewModel = mockViewModel
            )
        }

        // Assert
        composeTestRule.onNodeWithText("Error").assertExists()
        composeTestRule.onNodeWithText(errorMessage).assertExists()
        composeTestRule.onNodeWithText("Retry").assertExists()
    }
}
