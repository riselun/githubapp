/**
 * Application class for the GitHub App
 * Initializes Hilt dependency injection
 * 
 * @author Aaron Luo
 * @date May 7, 2025
 */
package com.example.githubapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GitHubApplication : Application()
