package com.ellepqe.alarmapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ellepqe.alarmapp.data.model.AppLanguage
import com.ellepqe.alarmapp.databinding.ItemLanguageBinding

class LanguageAdapter : ListAdapter<AppLanguage, LanguageAdapter.LanguageViewHolder>(
    LanguageDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val binding = ItemLanguageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LanguageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class LanguageViewHolder(private val binding: ItemLanguageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(language: AppLanguage) {
            binding.apply {
                languageKey.text = language.key
                languageDefaultValue.text = language.defaultValue
                languageCustomValue.setText(language.customValue)
            }
        }
    }

    class LanguageDiffCallback : DiffUtil.ItemCallback<AppLanguage>() {
        override fun areItemsTheSame(oldItem: AppLanguage, newItem: AppLanguage): Boolean {
            return oldItem.key == newItem.key
        }

        override fun areContentsTheSame(oldItem: AppLanguage, newItem: AppLanguage): Boolean {
            return oldItem == newItem
        }
    }
}
