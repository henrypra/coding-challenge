package com.henrypra.codingchallenge.feature.detail

import com.henrypra.codingchallenge.BaseActivity

class DetailPresenter(val activity: BaseActivity,
                      val actionListener: DetailActionListener,
                      val view: DetailContract.View) : DetailContract.Presenter {


}