package com.henrypra.codingchallenge.retrofit.endpoints.user

import android.content.Context
import com.henrypra.codingchallenge.retrofit.endpoints.user.response.User
import com.henrypra.codingchallenge.retrofit.essentials.Client
import com.henrypra.codingchallenge.retrofit.essentials.ServerCallback
import retrofit2.Response

object UserEndpoint {

    fun getSingleUser(context: Context?, callback: ServerCallback<User>) {
        val call = Client.getAPIClient().create(IUserEndpoint::class.java).getSingleUser("henrypra")

        call.enqueue(object : retrofit2.Callback<User> {
            override fun onResponse(call: retrofit2.Call<User>, response: Response<User>) {
                if (response.body() != null && response.isSuccessful) {
                    callback.onSuccess(response.body()!!)
                } else {
                    callback.onFailure()
                }
            }

            override fun onFailure(call: retrofit2.Call<User>, t: Throwable) {
                callback.onFailure()
            }
        })
    }

}
