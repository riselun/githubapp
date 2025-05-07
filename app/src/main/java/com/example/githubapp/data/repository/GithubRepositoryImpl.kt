/**
 * GitHub Repository Implementation
 * Implements the GithubRepository interface to provide data from the GitHub API
 * Handles error handling and data transformation
 * 
 * @author Aaron Luo
 * @date May 7, 2025
 */
package com.example.githubapp.data.repository

import com.example.githubapp.data.api.GithubApi
import com.example.githubapp.data.api.GithubApiClient
import com.example.githubapp.data.local.UserPreferences
import com.example.githubapp.data.model.Issue
import com.example.githubapp.data.model.IssueRequest
import com.example.githubapp.data.model.Repository
import com.example.githubapp.data.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubRepositoryImpl @Inject constructor(
    private val apiClient: GithubApiClient,
    private val userPreferences: UserPreferences
) : GithubRepository {

    private val api: GithubApi
        get() = apiClient.githubApi

    override suspend fun getTrendingRepositories(page: Int, perPage: Int): Result<List<Repository>> = runCatching {
        api.getTrendingRepositories(perPage = perPage, page = page).items
    }

    override suspend fun searchRepositories(query: String, language: String?, page: Int, perPage: Int): Result<List<Repository>> = runCatching {
        val searchQuery = if (language != null) {
            "$query language:$language"
        } else {
            query
        }
        api.searchRepositories(searchQuery, perPage = perPage, page = page).items
    }

    override suspend fun getRepository(owner: String, repo: String): Result<Repository> = runCatching {
        api.getRepository(owner, repo)
    }

    override suspend fun getRepositoryIssues(owner: String, repo: String, page: Int, perPage: Int): Result<List<Issue>> = runCatching {
        api.getRepositoryIssues(owner, repo, perPage = perPage, page = page)
    }

    override suspend fun login(token: String): Result<User> = runCatching {
        android.util.Log.d("GithubRepository", "Login attempt with token length: ${token.length}")
        
        // Save the token first
        userPreferences.saveAuthToken(token)
        android.util.Log.d("GithubRepository", "Token saved to preferences")
        
        // Create a direct API client with the token for login
        val loggingInterceptor = okhttp3.logging.HttpLoggingInterceptor().apply {
            level = okhttp3.logging.HttpLoggingInterceptor.Level.BODY
        }
        
        val directClient = okhttp3.OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .header("Authorization", "token $token")
                    .method(original.method, original.body)
                val request = requestBuilder.build()
                android.util.Log.d("GithubRepository", "Direct login request with Authorization header: token ${token.take(5)}...")
                chain.proceed(request)
            }
            .addInterceptor(loggingInterceptor)
            .build()
            
        val directRetrofit = retrofit2.Retrofit.Builder()
            .baseUrl(com.example.githubapp.util.Constants.GITHUB_API_BASE_URL)
            .client(directClient)
            .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
            .build()
            
        val directApi = directRetrofit.create(com.example.githubapp.data.api.GithubApi::class.java)
        android.util.Log.d("GithubRepository", "Created direct API client for login")
        
        // Then get the user profile using the direct client
        val user = directApi.getUserProfile()
        android.util.Log.d("GithubRepository", "User profile retrieved: ${user.username}")
        
        // Save the username
        userPreferences.saveUsername(user.username)
        android.util.Log.d("GithubRepository", "Username saved to preferences")
        
        user
    }

    override suspend fun logout() {
        userPreferences.clearUserData()
    }

    override fun isLoggedIn(): Flow<Boolean> {
        return userPreferences.authToken.map { it.isNotEmpty() }
    }

    override suspend fun getUserProfile(): Result<User> = runCatching {
        api.getUserProfile()
    }

    override suspend fun getUserRepositories(page: Int, perPage: Int): Result<List<Repository>> = runCatching {
        api.getUserRepositories(perPage = perPage, page = page)
    }

    override suspend fun createIssue(owner: String, repo: String, title: String, body: String): Result<Issue> = runCatching {
        val issueRequest = IssueRequest(title, body)
        api.createIssue(owner, repo, issueRequest)
    }
}
