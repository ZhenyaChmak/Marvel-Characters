package com.example.marvelcharacters.adapter.comics

import androidx.recyclerview.widget.RecyclerView
import com.example.marvelcharacters.databinding.FragmentCharacterComicsBinding
import com.example.marvelcharacters.domain.model.Comics

class ComicsViewHolder(
    private val binding: FragmentCharacterComicsBinding,
    private val onClickedComics: (Comics) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(comics: Comics) {
        with(binding) {

            root.setOnClickListener {
                onClickedComics(comics)
            }
        }
    }
}