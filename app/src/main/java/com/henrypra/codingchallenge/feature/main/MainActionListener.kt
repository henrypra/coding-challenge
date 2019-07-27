package com.henrypra.codingchallenge.feature.main

import com.henrypra.codingchallenge.retrofit.endpoints.gist.response.Gist

interface MainActionListener {
    fun onGistGoToDetail(gist: Gist)
}