package com.henrypra.codingchallenge.retrofit.endpoints.user

import com.henrypra.codingchallenge.retrofit.endpoints.user.response.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IUserEndpoint {

    @GET("users/{username}")
    fun getSingleUser(@Path("username") username: String): Call<User>
}