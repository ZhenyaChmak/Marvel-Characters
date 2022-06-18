package com.example.marvelcharacters.adapter.comics

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.marvelcharacters.databinding.FragmentCharacterComicsBinding
import com.example.marvelcharacters.domain.model.Comics

class ComicsViewHolder(
    private val binding: FragmentCharacterComicsBinding,
    private val onClickedComics: (Comics) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(comics: Comics) {
        with(binding) {

            photoComics.load(comics.photoComics)

            root.setOnClickListener {
                onClickedComics(comics)
            }
        }
    }
}