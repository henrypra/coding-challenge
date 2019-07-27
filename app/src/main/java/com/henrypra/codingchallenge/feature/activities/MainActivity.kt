package com.henrypra.codingchallenge.feature.activities

import android.content.Intent
import android.os.Bundle
import com.henrypra.codingchallenge.BaseActivity
import com.henrypra.codingchallenge.R
import com.henrypra.codingchallenge.feature.main.MainActionListener
import com.henrypra.codingchallenge.feature.main.MainFragment
import com.henrypra.codingchallenge.feature.main.MainPresenter
import com.henrypra.codingchallenge.retrofit.endpoints.gist.response.Gist
import com.henrypra.codingchallenge.utility.FragmentNavigation
import timber.log.Timber

class MainActivity : BaseActivity(),
        MainActionListener {

    val fragmentNavigation: FragmentNavigation by lazy { FragmentNavigation(R.id.main_fragment_container, this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadMainFragment()
        Timber.tag("TAG101").d("Timber Test")

    }

    private fun loadMainFragment() {
        val mainFragment = MainFragment()
        mainFragment.presenter = MainPresenter(this, this, mainFragment)
        fragmentNavigation.replaceFragment(mainFragment)
    }

    override fun onGistGoToDetail(gist: Gist) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra("id", gist.id)
        this@MainActivity.startActivity(intent)

    }
}
