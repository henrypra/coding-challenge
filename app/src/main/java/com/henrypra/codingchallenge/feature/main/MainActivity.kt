package com.henrypra.codingchallenge.feature.main

import android.os.Bundle
import com.henrypra.codingchallenge.R
import com.henrypra.codingchallenge.BaseActivity
import com.henrypra.codingchallenge.utility.FragmentNavigation

class MainActivity : BaseActivity(),
        MainActionListener {

    val fragmentNavigation: FragmentNavigation by lazy { FragmentNavigation(R.id.main_fragment_container, this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadMainFragment()
    }

    private fun loadMainFragment() {
        val mainFragment = MainFragment()
        mainFragment.presenter = MainPresenter(this, this, mainFragment)
        fragmentNavigation.replaceFragment(mainFragment)
    }
}
