/**
 * Network module for dependency injection
 * Provides network-related dependencies like API clients
 * 
 * @author Aaron Luo
 * @date May 7, 2025
 */
package com.example.githubapp.di

import com.example.githubapp.data.api.AuthTokenProvider
import com.example.githubapp.data.api.GithubApi
import com.example.githubapp.data.api.GithubApiClient
import com.example.githubapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    
    @Provides
    @Singleton
    fun provideGithubApiClient(authTokenProvider: AuthTokenProvider): GithubApiClient {
        return GithubApiClient(authTokenProvider)
    }
    
    @Provides
    @Singleton
    fun provideGithubApi(apiClient: GithubApiClient): GithubApi {
        return apiClient.githubApi
    }
}
