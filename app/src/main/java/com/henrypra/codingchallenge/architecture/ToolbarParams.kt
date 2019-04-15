package com.henrypra.codingchallenge.architecture

import com.henrypra.codingchallenge.BaseActivity
import com.henrypra.codingchallenge.R

class ToolbarParams(val activity: BaseActivity?,
                    val title: String? = "",
                    val subTitle: String? = null,
                    val showBackNavigation: Boolean = false,
                    val navIconId: Int = R.drawable.ic_arrow_back,
                    val hideToolbar: Boolean = false) {

    init {
        activity?.setupToolbar(this)
    }

}