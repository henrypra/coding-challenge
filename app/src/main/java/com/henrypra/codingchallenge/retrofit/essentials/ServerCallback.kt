package com.henrypra.codingchallenge.retrofit.essentials

interface ServerCallback<T> {

    fun onSuccess(response: T)

    fun onFailure()

}