package com.henrypra.codingchallenge.feature.main

import com.henrypra.codingchallenge.BaseActivity
import com.henrypra.codingchallenge.retrofit.endpoints.gist.GistEndpoint.getAllGists
import com.henrypra.codingchallenge.retrofit.endpoints.gist.response.Gist
import com.henrypra.codingchallenge.retrofit.essentials.RequestHelper
import com.henrypra.codingchallenge.retrofit.essentials.ServerCallback

class MainPresenter(val activity: BaseActivity,
                    val actionListener: MainActionListener,
                    val view: MainContract.View) : MainContract.Presenter {

    override fun retrieveGistData() {
        RequestHelper<MutableList<Gist>>().makeRequest(view.getCurrentContext(), object : RequestHelper.Request<MutableList<Gist>> {
            override fun action(callback: ServerCallback<MutableList<Gist>>) {
                getAllGists(view.getCurrentContext(), callback)
            }

            override fun onSuccess(response: MutableList<Gist>) {
                view.displayGistData(response)
            }

            override fun onFailure() {}
        })
    }

    override fun onGistClicked(gist: Gist) {
        actionListener.onGistGoToDetail(gist)
    }
}