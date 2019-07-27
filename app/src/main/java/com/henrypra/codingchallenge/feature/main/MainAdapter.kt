package com.henrypra.codingchallenge.feature.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.henrypra.codingchallenge.R
import com.henrypra.codingchallenge.retrofit.endpoints.gist.response.Gist
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_gists.view.*
import timber.log.Timber

class MainAdapter(val context: Context?, var listener: GistClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var gistList = mutableListOf<Gist>()

    private val viewTypeEmpty = 0
    private val viewTypeList = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            viewTypeList -> GistHolder(LayoutInflater.from(context).inflate(R.layout.item_gists, parent, false))
            else -> EmptyHolder(LinearLayout(context))
        }
    }

    override fun getItemCount(): Int {
        return gistList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is GistHolder -> initGist(holder, position)
        }
    }

    private fun initGist(holder: GistHolder, position: Int) {
        val currentGist = gistList[position]
        holder.author.text = context?.getString(R.string.gist_list_author_created_by) + currentGist.owner?.login
        holder.desc.text = currentGist.description
        Picasso.get().load(currentGist.owner?.avatarUrl).into(holder.avatar)
        holder.itemView.setOnClickListener {
            listener.onGistClicked(currentGist)
            Timber.tag("TAG101").d("Adapter")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (gistList.isNotEmpty()) viewTypeList else viewTypeEmpty
    }

    class GistHolder(view: View) : RecyclerView.ViewHolder(view) {
        val author = view.tv_author
        val desc = view.tv_desc
        val avatar = view.img_avatar
    }

    class EmptyHolder(view: View) : RecyclerView.ViewHolder(view)

    interface GistClickListener {

        fun onGistClicked(gist: Gist)

    }


}