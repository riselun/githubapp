/**
 * Issue data models
 * Represents GitHub issues and issue creation requests
 * 
 * @author Aaron Luo
 * @date May 7, 2025
 */
package com.example.githubapp.data.model

import com.google.gson.annotations.SerializedName

data class Issue(
    @SerializedName("id") val id: Long,
    @SerializedName("number") val number: Long,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String?,
    @SerializedName("user") val user: User,
    @SerializedName("state") val state: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("updated_at") val updatedAt: String,
    @SerializedName("comments") val comments: Long
)

data class IssueRequest(
    val title: String,
    val body: String
)
