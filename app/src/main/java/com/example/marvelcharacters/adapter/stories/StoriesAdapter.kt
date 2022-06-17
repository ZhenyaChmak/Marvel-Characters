package com.example.marvelcharacters.adapter.stories

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.marvelcharacters.databinding.FragmentCharacterStoriesBinding
import com.example.marvelcharacters.domain.model.Stories

class StoriesAdapter(
    context: Context,
    private val onClickedStories: (Stories) -> Unit
) : ListAdapter<Stories, StoriesVieHolder>(DIFF_UTIL) {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesVieHolder {
        return StoriesVieHolder(
            FragmentCharacterStoriesBinding.inflate(layoutInflater, parent, false),
            onClickedStories = onClickedStories
        )
    }

    override fun onBindViewHolder(holder: StoriesVieHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<Stories>() {
            override fun areItemsTheSame(oldItem: Stories, newItem: Stories): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Stories, newItem: Stories): Boolean {
                return oldItem == newItem
            }

        }
    }


}