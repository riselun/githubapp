/**
 * Repository data model
 * Represents a GitHub repository with its properties
 * 
 * @author Aaron Luo
 * @date May 7, 2025
 */
package com.example.githubapp.data.model

import com.google.gson.annotations.SerializedName

data class Repository(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("owner") val owner: User,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("description") val description: String?,
    @SerializedName("stargazers_count") val stars: Int,
    @SerializedName("forks_count") val forks: Int,
    @SerializedName("language") val language: String?,
    @SerializedName("open_issues_count") val openIssues: Int,
    @SerializedName("updated_at") val updatedAt: String
)
