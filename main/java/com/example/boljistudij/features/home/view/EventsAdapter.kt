package com.example.boljistudij.features.home.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.boljistudij.databinding.ItemEventBinding
import com.example.boljistudij.extensions.loadUrl
import com.example.boljistudij.features.home.model.EventModel

private class ItemsDiffUtilCallback : DiffUtil.ItemCallback<EventModel>() {
    override fun areItemsTheSame(
        oldItem: EventModel,
        newItem: EventModel,
    ) = oldItem == newItem

    override fun areContentsTheSame(
        oldItem: EventModel,
        newItem: EventModel,
    ) = oldItem == newItem
}

class EventsAdapter(
    val context: Context,
) : ListAdapter<EventModel, EventsAdapter.ViewHolder>(ItemsDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemEventBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemEventBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            elements: EventModel,
        ): Unit = with(elements) {
                binding.title.text = title
                binding.date.text = date
                binding.image.loadUrl(url)
        }
    }
}