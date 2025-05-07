/**
 * User data model
 * Represents a GitHub user with their profile information
 * 
 * @author Aaron Luo
 * @date May 7, 2025
 */
package com.example.githubapp.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("login") val username: String,
    @SerializedName("id") val id: Long,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("name") val name: String?,
    @SerializedName("bio") val bio: String?,
    @SerializedName("public_repos") val publicRepos: Int,
    @SerializedName("followers") val followers: Int,
    @SerializedName("following") val following: Int
)
