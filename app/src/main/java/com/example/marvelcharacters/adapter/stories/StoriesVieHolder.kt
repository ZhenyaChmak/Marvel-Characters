package com.example.marvelcharacters.adapter.stories

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.marvelcharacters.databinding.FragmentCharacterStoriesBinding
import com.example.marvelcharacters.domain.model.Stories

class StoriesVieHolder(
    private val binding: FragmentCharacterStoriesBinding,
    private val onClickedStories: (Stories) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(stories: Stories) {
        with(binding) {



            root.setOnClickListener {
                onClickedStories(stories)
            }
        }
    }
}