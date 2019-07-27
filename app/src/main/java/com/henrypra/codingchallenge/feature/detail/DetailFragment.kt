package com.henrypra.codingchallenge.feature.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.henrypra.codingchallenge.R
import com.henrypra.codingchallenge.architecture.BaseContractFragment
import com.henrypra.codingchallenge.retrofit.endpoints.gist.response.Gist
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : BaseContractFragment<DetailContract.Presenter>(), DetailContract.View, FilesAdapter.FileClickListener {

    private val adapter: FilesAdapter by lazy { FilesAdapter(getCurrentContext(), this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.retrieveGistForId()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rv_files?.layoutManager = LinearLayoutManager(getCurrentContext(), LinearLayoutManager.VERTICAL, false)
        rv_files?.setHasFixedSize(true)
        rv_files?.adapter = adapter
    }

    override fun displayGist(gist: Gist) {
        tv_author?.text = "by " + gist.owner?.login.toString()
        Picasso.get().load(gist.owner?.avatarUrl).into(img_avatar)
        if (gist.description.toString().isEmpty()) {
            tv_description?.visibility = View.GONE
        } else {
            tv_description?.visibility = View.VISIBLE
            tv_description?.text = gist.description.toString()
        }

        adapter.files = gist.files.values.toMutableList()
        adapter.notifyDataSetChanged()

    }
}