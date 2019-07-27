package com.henrypra.codingchallenge.retrofit.endpoints.gist.response

import com.google.gson.annotations.SerializedName

data class Gist(@SerializedName("comments")
                val comments: Int? = 0,
                @SerializedName("comments_url")
                val commentsUrl: String? = "",
                @SerializedName("commits_url")
                val commitsUrl: String? = "",
                @SerializedName("created_at")
                val createdAt: String? = "",
                @SerializedName("description")
                val description: String? = "",
                @SerializedName("forks")
                val forks: List<Fork?>? = listOf(),
                @SerializedName("forks_url")
                val forksUrl: String? = "",
                @SerializedName("git_pull_url")
                val gitPullUrl: String? = "",
                @SerializedName("git_push_url")
                val gitPushUrl: String? = "",
                @SerializedName("history")
                val history: List<History?>? = listOf(),
                @SerializedName("html_url")
                val htmlUrl: String? = "",
                @SerializedName("files")
                val files: Map<String, GistFiles>,
                val gistFiles: List<GistFiles?>? = listOf(),
                @SerializedName("id")
                val id: String? = "",
                @SerializedName("node_id")
                val nodeId: String? = "",
                @SerializedName("owner")
                val owner: Owner? = Owner(),
                @SerializedName("public")
                val `public`: Boolean? = false,
                @SerializedName("truncated")
                val truncated: Boolean? = false,
                @SerializedName("updated_at")
                val updatedAt: String? = "",
                @SerializedName("url")
                val url: String? = "",
                @SerializedName("user")
                val user: Any? = Any()
)