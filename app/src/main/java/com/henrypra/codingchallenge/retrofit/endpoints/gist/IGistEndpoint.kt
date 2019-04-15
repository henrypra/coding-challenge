package com.henrypra.codingchallenge.retrofit.endpoints.gist

import com.henrypra.codingchallenge.retrofit.endpoints.gist.response.Gist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IGistEndpoint {

    @GET("gists/public")
    fun getAllGists(): Call<MutableList<Gist>>

    @GET("users/{username}/gists")
    fun getUserGists(@Path("username") username: String): Call<List<Gist>>

    @GET("gists/starred")
    fun getStarredGists(): Call<List<Gist>>

    @GET("gists/{gist_id}")
    fun getSingleGist(@Path("gist_id") id: Int): Call<Gist>
}