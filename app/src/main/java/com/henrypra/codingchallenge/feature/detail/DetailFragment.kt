package com.henrypra.codingchallenge.feature.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.henrypra.codingchallenge.R
import com.henrypra.codingchallenge.architecture.BaseContractFragment
import com.henrypra.codingchallenge.retrofit.endpoints.gist.response.Gist
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_creation.*

class DetailFragment : BaseContractFragment<DetailContract.Presenter>(), DetailContract.View {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_creation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadGistData()
    }

    private fun loadGistData() {
        presenter?.retrieveGistForId()
    }

    override fun displayGist(gist: Gist) {
        tv_author_file?.text = gist.owner?.login.toString()
        Picasso.get().load(gist.owner?.avatarUrl).into(img_avatar)
        tv_description?.text = gist.description.toString()

    }
}