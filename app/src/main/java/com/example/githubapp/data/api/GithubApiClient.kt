/**
 * GitHub API Client
 * Handles network requests to the GitHub API
 * 
 * @author Aaron Luo
 * @date May 7, 2025
 */
package com.example.githubapp.data.api

import android.util.Log
import com.example.githubapp.util.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubApiClient @Inject constructor(
    private val authTokenProvider: AuthTokenProvider
) {
    init {
        Log.d("GithubApiClient", "Initializing GitHub API Client")
    }
    
    private val authInterceptor = AuthInterceptor(authTokenProvider).also {
        Log.d("GithubApiClient", "Created AuthInterceptor")
    }
    
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
        Log.d("GithubApiClient", "Set logging interceptor level to BODY")
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .addInterceptor(loggingInterceptor)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build().also {
            Log.d("GithubApiClient", "Built OkHttpClient with interceptors")
        }

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.GITHUB_API_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build().also {
            Log.d("GithubApiClient", "Built Retrofit instance with base URL: ${Constants.GITHUB_API_BASE_URL}")
        }

    val githubApi: GithubApi = retrofit.create(GithubApi::class.java).also {
        Log.d("GithubApiClient", "Created GithubApi interface implementation")
    }
}

/**
 * Authentication interceptor for GitHub API requests
 * Adds the Authorization header with the GitHub token
 * 
 * @author Aaron Luo
 * @date May 7, 2025
 */
class AuthInterceptor(private val authTokenProvider: AuthTokenProvider) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val token = authTokenProvider.getAuthToken()
        
        android.util.Log.d("AuthInterceptor", "Token retrieved: ${if (token.isNotEmpty()) "[non-empty token]" else "[empty token]"}, length: ${token.length}")
        
        return if (token.isNotEmpty()) {
            val newRequest = originalRequest.newBuilder()
                .header("Authorization", "token $token")
                .build()
            android.util.Log.d("AuthInterceptor", "Added Authorization header: token ${token.take(5)}...")
            chain.proceed(newRequest)
        } else {
            android.util.Log.d("AuthInterceptor", "No token available, proceeding without Authorization header")
            chain.proceed(originalRequest)
        }
    }
}

interface AuthTokenProvider {
    fun getAuthToken(): String
}
