package com.henrypra.codingchallenge.feature.detail

import com.henrypra.codingchallenge.architecture.BasePresenter
import com.henrypra.codingchallenge.architecture.BaseView
import com.henrypra.codingchallenge.retrofit.endpoints.gist.response.Gist

interface DetailContract {

    interface Presenter : BasePresenter {

        fun retrieveGistForId()

    }

    interface View : BaseView<Presenter> {

        fun displayGist(gist: Gist)

    }
}