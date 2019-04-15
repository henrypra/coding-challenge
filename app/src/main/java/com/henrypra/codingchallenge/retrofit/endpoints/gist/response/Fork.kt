package com.henrypra.codingchallenge.retrofit.endpoints.gist.response

import com.google.gson.annotations.SerializedName

data class Fork(@SerializedName("created_at")
                val createdAt: String? = "",
                @SerializedName("id")
                val id: String? = "",
                @SerializedName("updated_at")
                val updatedAt: String? = "",
                @SerializedName("url")
                val url: String? = "",
                @SerializedName("user")
                val user: User? = User()
)