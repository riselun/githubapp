package com.example.githubapp.ui.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.githubapp.data.model.User
import com.example.githubapp.data.repository.GithubRepository
import com.example.githubapp.util.NetworkUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class LoginViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()

    @Mock
    private lateinit var githubRepository: GithubRepository

    @Mock
    private lateinit var networkUtils: NetworkUtils

    private lateinit var loginViewModel: LoginViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        loginViewModel = LoginViewModel(githubRepository, networkUtils)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `login with empty token returns error state`() = runTest {
        // Act
        loginViewModel.login("")

        // Assert
        val state = loginViewModel.uiState.first()
        assertTrue(state is LoginUiState.Error)
        assertEquals("Token cannot be empty", (state as LoginUiState.Error).message)
    }

    @Test
    fun `login with valid token returns success state`() = runTest {
        // Arrange
        val token = "valid_token"
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
        
        `when`(githubRepository.login(token)).thenReturn(Result.success(mockUser))

        // Act
        loginViewModel.login(token)
        testDispatcher.scheduler.advanceUntilIdle()

        // Assert
        val state = loginViewModel.uiState.first()
        assertTrue(state is LoginUiState.Success)
        assertEquals("testuser", (state as LoginUiState.Success).username)
    }

    @Test
    fun `login with invalid token returns error state`() = runTest {
        // Arrange
        val token = "invalid_token"
        val errorMessage = "Authentication failed"
        
        `when`(githubRepository.login(token)).thenReturn(Result.failure(RuntimeException()))
        `when`(networkUtils.getErrorMessage(any())).thenReturn(errorMessage)

        // Act
        loginViewModel.login(token)
        testDispatcher.scheduler.advanceUntilIdle()

        // Assert
        val state = loginViewModel.uiState.first()
        assertTrue(state is LoginUiState.Error)
        assertEquals(errorMessage, (state as LoginUiState.Error).message)
    }
    
    // Helper function to match any exception for Mockito
    private fun <T> any(): T {
        org.mockito.Mockito.any<T>()
        return null as T
    }
}
