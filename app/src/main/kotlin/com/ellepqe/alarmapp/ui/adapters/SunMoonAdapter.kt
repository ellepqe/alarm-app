package com.ellepqe.alarmapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ellepqe.alarmapp.databinding.ItemSunMoonBinding

class SunMoonAdapter : ListAdapter<Any, SunMoonAdapter.SunMoonViewHolder>(SunMoonDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SunMoonViewHolder {
        val binding = ItemSunMoonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SunMoonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SunMoonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class SunMoonViewHolder(private val binding: ItemSunMoonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Any) {
            binding.apply {
                sunMoonTitle.text = item.toString()
            }
        }
    }

    class SunMoonDiffCallback : DiffUtil.ItemCallback<Any>() {
        override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
            return oldItem == newItem
        }
    }
}
