package com.example.githubapp.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkUtils @Inject constructor(
    @ApplicationContext private val context: Context
) {
    fun isNetworkAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
    }
    
    fun getErrorMessage(throwable: Throwable): String {
        return when {
            !isNetworkAvailable() -> Constants.NETWORK_ERROR_MESSAGE
            throwable.message?.contains("401") == true -> Constants.UNAUTHORIZED_ERROR_MESSAGE
            throwable.message?.contains("404") == true -> Constants.NOT_FOUND_ERROR_MESSAGE
            throwable.message?.contains("5") == true -> Constants.SERVER_ERROR_MESSAGE
            else -> throwable.message ?: "An unknown error occurred"
        }
    }
}
