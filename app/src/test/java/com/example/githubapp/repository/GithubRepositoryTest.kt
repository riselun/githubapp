package com.example.githubapp.repository

import com.example.githubapp.data.api.GithubApi
import com.example.githubapp.data.api.GithubApiClient
import com.example.githubapp.data.api.SearchResponse
import com.example.githubapp.data.local.UserPreferences
import com.example.githubapp.data.model.Repository
import com.example.githubapp.data.model.User
import com.example.githubapp.data.repository.GithubRepositoryImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class GithubRepositoryTest {

    @Mock
    private lateinit var apiClient: GithubApiClient

    @Mock
    private lateinit var githubApi: GithubApi

    @Mock
    private lateinit var userPreferences: UserPreferences

    private lateinit var githubRepository: GithubRepositoryImpl

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        `when`(apiClient.githubApi).thenReturn(githubApi)
        githubRepository = GithubRepositoryImpl(apiClient, userPreferences)
    }

    @Test
    fun `getTrendingRepositories returns successful result when API call succeeds`() = runBlocking {
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
        
        val searchResponse = SearchResponse(
            total_count = 1,
            incomplete_results = false,
            items = mockRepositories
        )
        
        `when`(githubApi.getTrendingRepositories()).thenReturn(searchResponse)
        
        // Act
        val result = githubRepository.getTrendingRepositories()
        
        // Assert
        assertTrue(result.isSuccess)
        assertEquals(mockRepositories, result.getOrNull())
    }
    
    /**
     * Test that isLoggedIn correctly maps the authToken flow to a boolean flow
     */
    @Test
    fun `isLoggedIn returns flow of authentication state`() {
        // Arrange
        val authTokenFlow: Flow<String> = flowOf("test_token")
        `when`(userPreferences.authToken).thenReturn(authTokenFlow)
        
        // Act & Assert
        runBlocking {
            // Collect the flow and verify the value
            githubRepository.isLoggedIn().collect { isLoggedIn ->
                assertTrue(isLoggedIn)
            }
        }
    }
    
    /**
     * Test that isLoggedIn returns false when token is empty
     */
    @Test
    fun `isLoggedIn returns false when token is empty`() {
        // Arrange
        val emptyTokenFlow: Flow<String> = flowOf("")
        `when`(userPreferences.authToken).thenReturn(emptyTokenFlow)
        
        // Act & Assert
        runBlocking {
            githubRepository.isLoggedIn().collect { isLoggedIn ->
                assertFalse(isLoggedIn)
            }
        }
    }
}
