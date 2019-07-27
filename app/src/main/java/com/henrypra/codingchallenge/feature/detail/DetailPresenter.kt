package com.henrypra.codingchallenge.feature.detail

import com.henrypra.codingchallenge.BaseActivity
import com.henrypra.codingchallenge.retrofit.endpoints.gist.GistEndpoint
import com.henrypra.codingchallenge.retrofit.endpoints.gist.response.Gist
import com.henrypra.codingchallenge.retrofit.essentials.RequestHelper
import com.henrypra.codingchallenge.retrofit.essentials.ServerCallback

class DetailPresenter(val activity: BaseActivity,
                      val gistId: String,
                      val actionListener: DetailActionListener?,
                      val view: DetailContract.View) : DetailContract.Presenter {

    override fun retrieveGistForId() {
        RequestHelper<Gist>().makeRequest(view.getCurrentContext(), object : RequestHelper.Request<Gist> {
            override fun action(callback: ServerCallback<Gist>) {
                GistEndpoint.getGistForId(view.getCurrentContext(), gistId, callback)
            }

            override fun onSuccess(response: Gist) {
                view.displayGist(response)
            }

            override fun onFailure() {}
        })
    }


}