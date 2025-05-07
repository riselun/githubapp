/**
 * Application module for dependency injection
 * Provides bindings for repositories and data sources
 * 
 * @author Aaron Luo
 * @date May 7, 2025
 */
package com.example.githubapp.di

import com.example.githubapp.data.api.AuthTokenProvider
import com.example.githubapp.data.local.UserPreferences
import com.example.githubapp.data.repository.GithubRepository
import com.example.githubapp.data.repository.GithubRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    
    @Binds
    @Singleton
    abstract fun bindGithubRepository(
        githubRepositoryImpl: GithubRepositoryImpl
    ): GithubRepository
    
    @Binds
    @Singleton
    abstract fun bindAuthTokenProvider(
        userPreferences: UserPreferences
    ): AuthTokenProvider
}
