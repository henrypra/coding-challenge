package com.henrypra.codingchallenge

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.henrypra.codingchallenge.architecture.ToolbarParams
import kotlinx.android.synthetic.main.default_toolbar.*
import timber.log.Timber

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item?.itemId == android.R.id.home) {
            onBackPressed()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    fun setupToolbar(toolbarParams: ToolbarParams) {
        toolbarParams.title?.let {
            onShowBackNavigation(toolbarParams.title,
                    toolbarParams.subTitle,
                    toolbarParams.showBackNavigation,
                    toolbarParams.navIconId,
                    toolbarParams.hideToolbar)
        }
    }

    private fun onShowBackNavigation(title: String?, subTitle: String?, showBackNavigation: Boolean, navdrawableId: Int, hideToolbar: Boolean) {
        if (default_toolbar != null) {
            if (hideToolbar) {
                default_toolbar.visibility = View.GONE
            } else {
                default_toolbar.visibility = View.VISIBLE
                default_toolbar.title = title
                if (subTitle != null && !subTitle.isEmpty()) {
                    default_toolbar.subtitle = subTitle
                }
                setSupportActionBar(default_toolbar)
                val actionBar = supportActionBar
                if (actionBar != null) {
                    actionBar.setDisplayShowTitleEnabled(true)
                    if (showBackNavigation) {
                        actionBar.setDisplayHomeAsUpEnabled(true)
                        actionBar.setHomeButtonEnabled(true)
                        actionBar.setHomeAsUpIndicator(navdrawableId)
                    } else {
                        actionBar.setDisplayHomeAsUpEnabled(false)
                        actionBar.setHomeButtonEnabled(false)
                    }
                    actionBar.title = title
                    if (subTitle != null && !subTitle.isEmpty()) {
                        actionBar.subtitle = subTitle
                    } else {
                        actionBar.subtitle = ""
                    }
                }
            }
        }
    }


}