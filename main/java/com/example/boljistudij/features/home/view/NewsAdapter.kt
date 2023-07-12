package com.example.boljistudij.features.home.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.boljistudij.databinding.ItemNewsBinding
import com.example.boljistudij.extensions.loadUrl
import com.example.boljistudij.features.home.model.NewsModel

private class ItemsNewsDiffUtilCallback : DiffUtil.ItemCallback<NewsModel>() {
    override fun areItemsTheSame(
        oldItem: NewsModel,
        newItem: NewsModel,
    ) = oldItem == newItem

    override fun areContentsTheSame(
        oldItem: NewsModel,
        newItem: NewsModel,
    ) = oldItem == newItem
}

class NewsAdapter(
    val context: Context,
) : ListAdapter<NewsModel, NewsAdapter.ViewHolder>(ItemsNewsDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            newsModel: NewsModel,
        ): Unit = with(newsModel) {
            binding.title.text = title
            binding.profileImage.loadUrl(profileImage)
            binding.authorData.text = author
            binding.description.text = news
            binding.date.text = publishedDate
        }
    }
}