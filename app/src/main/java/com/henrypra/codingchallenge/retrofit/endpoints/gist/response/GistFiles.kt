package com.henrypra.codingchallenge.retrofit.endpoints.gist.response

import com.google.gson.annotations.SerializedName

data class GistFiles(@SerializedName("filename")
                     val filename: String? = "",
                     @SerializedName("type")
                     val type: String? = "",
                     @SerializedName("language")
                     val language: String? = "",
                     @SerializedName("raw_url")
                     val raw_url: String? = "",
                     @SerializedName("size")
                     val size: Int?,
                     @SerializedName("truncated")
                     val truncated: Boolean?,
                     @SerializedName("content")
                     val content: String?

)