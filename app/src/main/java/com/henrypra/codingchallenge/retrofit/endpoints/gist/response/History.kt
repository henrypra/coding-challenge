package com.henrypra.codingchallenge.retrofit.endpoints.gist.response

import com.google.gson.annotations.SerializedName

data class History(@SerializedName("committed_at")
                   val committedAt: String? = "",
                   @SerializedName("url")
                   val url: String? = "",
                   @SerializedName("user")
                   val user: User? = User(),
                   @SerializedName("version")
                   val version: String? = ""
)