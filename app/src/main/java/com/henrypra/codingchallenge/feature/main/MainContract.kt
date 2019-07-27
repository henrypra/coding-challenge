package com.henrypra.codingchallenge.feature.main

import com.henrypra.codingchallenge.architecture.BasePresenter
import com.henrypra.codingchallenge.architecture.BaseView
import com.henrypra.codingchallenge.retrofit.endpoints.gist.response.Gist

interface MainContract {

    interface Presenter : BasePresenter {
        fun retrieveGistData()

        fun onGistClicked(gist: Gist)
    }

    interface View : BaseView<Presenter> {
        fun displayGistData(gists: MutableList<Gist>)
    }
}