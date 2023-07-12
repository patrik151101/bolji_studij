package com.example.boljistudij.features.home.view

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.boljistudij.R
import com.example.boljistudij.databinding.ItemScheduleBinding
import com.example.boljistudij.extensions.loadUrl
import com.example.boljistudij.features.home.model.ScheduleModel

private class ItemsScheduleDiffUtilCallback : DiffUtil.ItemCallback<ScheduleModel>() {
    override fun areItemsTheSame(
        oldItem: ScheduleModel,
        newItem: ScheduleModel,
    ) = oldItem == newItem

    override fun areContentsTheSame(
        oldItem: ScheduleModel,
        newItem: ScheduleModel,
    ) = oldItem == newItem
}

class ScheduleAdapter(
    val context: Context,
) : ListAdapter<ScheduleModel, ScheduleAdapter.ViewHolder>(ItemsScheduleDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemScheduleBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), context)
    }

    class ViewHolder(private val binding: ItemScheduleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            scheduleModel: ScheduleModel,
            context: Context,
        ): Unit = with(scheduleModel) {
            binding.dayText.text = day
            binding.profileImage.loadUrl(profileImage)
            binding.monthText.text = month
            binding.teacherFullName.text = fullName
            binding.time.text = time
            binding.courseTitle.text = course
            if (isCourse) {
                binding.backgroundView.setBackgroundColor(context.resources!!.getColor(R.color.primary))
            } else {
                binding.backgroundView.setBackgroundColor(context.resources!!.getColor(R.color.blue))
            }
        }
    }
}