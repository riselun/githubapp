package com.example.githubapp.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.githubapp.data.model.Repository
import com.example.githubapp.data.model.User
import com.example.githubapp.data.repository.GithubRepository
import com.example.githubapp.util.NetworkUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
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
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()

    @Mock
    private lateinit var githubRepository: GithubRepository

    @Mock
    private lateinit var networkUtils: NetworkUtils

    private lateinit var homeViewModel: HomeViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        
        // Setup login state flow
        val isLoggedInFlow = MutableStateFlow(false)
        `when`(githubRepository.isLoggedIn()).thenReturn(isLoggedInFlow)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadTrendingRepositories success updates state to Success`() = runTest {
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
        
        `when`(githubRepository.getTrendingRepositories()).thenReturn(Result.success(mockRepositories))
        
        // Initialize ViewModel after setting up the mock
        homeViewModel = HomeViewModel(githubRepository, networkUtils)
        testDispatcher.scheduler.advanceUntilIdle()
        
        // Assert
        val state = homeViewModel.uiState.first()
        assertTrue(state is HomeUiState.Success)
        assertEquals(mockRepositories, (state as HomeUiState.Success).repositories)
    }

    @Test
    fun `loadTrendingRepositories failure updates state to Error`() = runTest {
        // Arrange
        val errorMessage = "Network error"
        val exception = RuntimeException("API error")
        
        `when`(githubRepository.getTrendingRepositories()).thenReturn(Result.failure(exception))
        `when`(networkUtils.getErrorMessage(exception)).thenReturn(errorMessage)
        
        // Initialize ViewModel after setting up the mock
        homeViewModel = HomeViewModel(githubRepository, networkUtils)
        testDispatcher.scheduler.advanceUntilIdle()
        
        // Assert
        val state = homeViewModel.uiState.first()
        assertTrue(state is HomeUiState.Error)
        assertEquals(errorMessage, (state as HomeUiState.Error).message)
    }

    @Test
    fun `isLoggedIn state is updated when repository login state changes`() = runTest {
        // Arrange
        val isLoggedInFlow = MutableStateFlow(false)
        `when`(githubRepository.isLoggedIn()).thenReturn(isLoggedInFlow)
        
        // Initialize ViewModel after setting up the mock
        homeViewModel = HomeViewModel(githubRepository, networkUtils)
        testDispatcher.scheduler.advanceUntilIdle()
        
        // Initial state
        assertEquals(false, homeViewModel.isLoggedIn.first())
        
        // Change login state
        isLoggedInFlow.value = true
        testDispatcher.scheduler.advanceUntilIdle()
        
        // Assert
        assertEquals(true, homeViewModel.isLoggedIn.first())
    }
}
