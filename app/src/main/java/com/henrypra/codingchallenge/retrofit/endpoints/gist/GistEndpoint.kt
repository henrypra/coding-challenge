package com.henrypra.codingchallenge.retrofit.endpoints.gist

import android.content.Context
import com.henrypra.codingchallenge.retrofit.endpoints.gist.response.Gist
import com.henrypra.codingchallenge.retrofit.essentials.Client
import com.henrypra.codingchallenge.retrofit.essentials.ServerCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object GistEndpoint {

    fun getAllGists(context: Context?, callback: ServerCallback<MutableList<Gist>>) {
        val call = Client.getAPIClient().create(IGistEndpoint::class.java).getAllGists()

        call.enqueue(object : Callback<MutableList<Gist>> {
            override fun onResponse(call: Call<MutableList<Gist>>, response: Response<MutableList<Gist>>) {
                if (response.body() != null && response.isSuccessful) {
                    callback.onSuccess(response.body()!!)
                } else {
                    callback.onFailure()
                }
            }

            override fun onFailure(call: Call<MutableList<Gist>>, t: Throwable) {
                callback.onFailure()
            }
        })
    }
}