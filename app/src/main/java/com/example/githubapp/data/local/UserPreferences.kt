/**
 * User preferences manager
 * Handles storing and retrieving user data like auth tokens and username
 * 
 * @author Aaron Luo
 * @date May 7, 2025
 */
package com.example.githubapp.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.githubapp.data.api.AuthTokenProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "github_user_prefs")

@Singleton
class UserPreferences @Inject constructor(
    @ApplicationContext private val context: Context
) : AuthTokenProvider {
    
    private val authTokenKey = stringPreferencesKey("auth_token")
    private val usernameKey = stringPreferencesKey("username")
    
    val authToken: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[authTokenKey] ?: ""
    }
    
    val username: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[usernameKey] ?: ""
    }
    
    suspend fun saveAuthToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[authTokenKey] = token
        }
    }
    
    suspend fun saveUsername(username: String) {
        context.dataStore.edit { preferences ->
            preferences[usernameKey] = username
        }
    }
    
    suspend fun clearUserData() {
        context.dataStore.edit { preferences ->
            preferences.remove(authTokenKey)
            preferences.remove(usernameKey)
        }
    }
    
    /**
     * Gets the current auth token synchronously
     * Note: This blocks the current thread to get the value from DataStore
     * This is only used by the AuthInterceptor and should be used carefully
     */
    override fun getAuthToken(): String {
        return runBlocking {
            authToken.first()
        }
    }
}
