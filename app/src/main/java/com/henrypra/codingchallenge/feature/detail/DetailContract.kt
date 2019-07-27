package com.henrypra.codingchallenge.feature.detail

import com.henrypra.codingchallenge.architecture.BasePresenter
import com.henrypra.codingchallenge.architecture.BaseView

interface DetailContract {

    interface Presenter : BasePresenter

    interface View: BaseView<Presenter>
}