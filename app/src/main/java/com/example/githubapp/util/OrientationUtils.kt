package com.example.githubapp.util

import android.content.Context
import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration

/**
 * Utility class for handling orientation-related functionality
 */
object OrientationUtils {
    
    /**
     * Check if the device is in landscape orientation
     * 
     * @param context The application context
     * @return True if the device is in landscape orientation, false otherwise
     */
    fun isLandscape(context: Context): Boolean {
        return context.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    }
    
    /**
     * Composable function to check if the device is in landscape orientation
     * 
     * @return True if the device is in landscape orientation, false otherwise
     */
    @Composable
    fun isLandscape(): Boolean {
        val configuration = LocalConfiguration.current
        return remember(configuration) {
            configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
        }
    }
}
