package com.example.githubapp.data.repository

import com.example.githubapp.data.api.SearchResponse
import com.example.githubapp.data.model.Issue
import com.example.githubapp.data.model.IssueRequest
import com.example.githubapp.data.model.Repository
import com.example.githubapp.data.model.User
import kotlinx.coroutines.flow.Flow

interface GithubRepository {
    // Anonymous user operations
    suspend fun getTrendingRepositories(page: Int = 1, perPage: Int = 30): Result<List<Repository>>
    suspend fun searchRepositories(query: String, language: String? = null, page: Int = 1, perPage: Int = 30): Result<List<Repository>>
    suspend fun getRepository(owner: String, repo: String): Result<Repository>
    suspend fun getRepositoryIssues(owner: String, repo: String, page: Int = 1, perPage: Int = 20): Result<List<Issue>>
    
    // Authentication
    suspend fun login(token: String): Result<User>
    suspend fun logout()
    fun isLoggedIn(): Flow<Boolean>
    
    // Authenticated user operations
    suspend fun getUserProfile(): Result<User>
    suspend fun getUserRepositories(page: Int = 1, perPage: Int = 30): Result<List<Repository>>
    suspend fun createIssue(owner: String, repo: String, title: String, body: String): Result<Issue>
}
