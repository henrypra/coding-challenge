package com.henrypra.codingchallenge.feature.activities

import android.os.Bundle
import com.henrypra.codingchallenge.BaseActivity
import com.henrypra.codingchallenge.R
import com.henrypra.codingchallenge.feature.detail.DetailActionListener
import com.henrypra.codingchallenge.feature.detail.DetailFragment
import com.henrypra.codingchallenge.feature.detail.DetailPresenter
import com.henrypra.codingchallenge.utility.FragmentNavigation

class DetailActivity : BaseActivity(),
        DetailActionListener {

    val fragmentNavigation: FragmentNavigation by lazy { FragmentNavigation(R.id.detail_fragment_container, this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        loadDetailFragment()
    }

    private fun loadDetailFragment() {
        val detailFragment = DetailFragment()
        detailFragment.presenter = DetailPresenter(this, intent.getStringExtra("id"), this, detailFragment)
        fragmentNavigation.replaceFragment(detailFragment)
    }
}
