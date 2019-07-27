package com.henrypra.codingchallenge.feature.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.henrypra.codingchallenge.R
import com.henrypra.codingchallenge.retrofit.endpoints.gist.response.GistFiles
import kotlinx.android.synthetic.main.item_file.view.*


class FilesAdapter(val context: Context?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var files = mutableListOf<GistFiles>()
    private val viewTypeEmpty = 0
    private val viewTypeList = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            viewTypeList -> FileHolder(LayoutInflater.from(context).inflate(R.layout.item_file, parent, false))
            else -> EmptyHolder(LinearLayout(context))
        }
    }

    override fun getItemCount(): Int {
        return files.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FileHolder -> initGist(holder, position)
        }
    }

    private fun initGist(holder: FileHolder, position: Int) {
        val currentFile = files[position]
        holder.filename.text = currentFile.filename
        holder.content.text = currentFile.content
    }

    override fun getItemViewType(position: Int): Int {
        return if (files.isNotEmpty()) viewTypeList else viewTypeEmpty
    }

    class FileHolder(view: View) : RecyclerView.ViewHolder(view) {
        val filename = view.tv_filename
        val content = view.tv_file_content
    }

    class EmptyHolder(view: View) : RecyclerView.ViewHolder(view)


}