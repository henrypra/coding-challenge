package com.henrypra.codingchallenge.retrofit.essentials

import android.content.Context

class RequestHelper<T> {

    fun makeRequest(context: Context?, request: Request<T>, showProgressDialog: Boolean = false) {
        val callback = object : ServerCallback<T> {
            override fun onSuccess(response: T) {
                request.onSuccess(response)
            }

            override fun onFailure() {
                request.onFailure()
            }
        }
        request.action(callback)
    }

    interface Request<T> {

        fun action(callback: ServerCallback<T>)


        fun onSuccess(response: T)


        fun onFailure()

    }

}