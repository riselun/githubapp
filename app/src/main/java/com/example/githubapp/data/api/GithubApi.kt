/**
 * GitHub API interface
 * Defines all the API endpoints for interacting with the GitHub REST API
 * 
 * @author Aaron Luo
 * @date May 7, 2025
 */
package com.example.githubapp.data.api

import com.example.githubapp.data.model.Issue
import com.example.githubapp.data.model.IssueRequest
import com.example.githubapp.data.model.Repository
import com.example.githubapp.data.model.User
import retrofit2.http.*

interface GithubApi {
    // Trending repositories
    @GET("search/repositories")
    suspend fun getTrendingRepositories(
        @Query("q") query: String = "stars:>1",
        @Query("sort") sort: String = "stars",
        @Query("order") order: String = "desc",
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): SearchResponse<Repository>
    
    // Search repositories
    @GET("search/repositories")
    suspend fun searchRepositories(
        @Query("q") query: String,
        @Query("sort") sort: String = "stars",
        @Query("order") order: String = "desc",
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): SearchResponse<Repository>
    
    // Repository details
    @GET("repos/{owner}/{repo}")
    suspend fun getRepository(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Repository
    
    // Repository issues
    @GET("repos/{owner}/{repo}/issues")
    suspend fun getRepositoryIssues(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("state") state: String = "open",
        @Query("per_page") perPage: Int = 20,
        @Query("page") page: Int = 1
    ): List<Issue>
    
    // Create an issue
    @POST("repos/{owner}/{repo}/issues")
    suspend fun createIssue(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body issueRequest: IssueRequest
    ): Issue
    
    // User profile
    @GET("user")
    suspend fun getUserProfile(): User
    
    // User repositories
    @GET("user/repos")
    suspend fun getUserRepositories(
        @Query("sort") sort: String = "updated",
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Repository>
    
    // Get a specific user
    @GET("users/{username}")
    suspend fun getUser(
        @Path("username") username: String
    ): User
    
    // Get repositories for a specific user
    @GET("users/{username}/repos")
    suspend fun getUserRepositories(
        @Path("username") username: String,
        @Query("sort") sort: String = "updated",
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Repository>
}

data class SearchResponse<T>(
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: List<T>
)
