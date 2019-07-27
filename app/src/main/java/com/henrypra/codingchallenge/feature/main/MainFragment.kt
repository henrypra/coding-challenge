package com.henrypra.codingchallenge.feature.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.henrypra.codingchallenge.R
import com.henrypra.codingchallenge.architecture.BaseContractFragment
import com.henrypra.codingchallenge.retrofit.endpoints.gist.response.Gist
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseContractFragment<MainContract.Presenter>(), MainContract.View, MainAdapter.GistClickListener {

    private val adapter: MainAdapter by lazy { MainAdapter(getCurrentContext(), this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.retrieveGistData()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rv_gists?.layoutManager = LinearLayoutManager(getCurrentContext(), LinearLayoutManager.VERTICAL, false)
        rv_gists?.setHasFixedSize(true)
        rv_gists?.adapter = adapter
    }

    override fun displayGistData(gists: MutableList<Gist>) {
        adapter.gistList = gists
        adapter.notifyDataSetChanged()
    }

    override fun onGistClicked(gist: Gist) {
        presenter?.onGistClicked(gist)
    }
}

