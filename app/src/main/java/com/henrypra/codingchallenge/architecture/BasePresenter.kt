package com.henrypra.codingchallenge.architecture

interface BasePresenter {

    fun onFragmentStart() {}

    fun onFragmentResume() {}

    fun onFragmentPause() {}

    fun onFragmentStop() {}

}