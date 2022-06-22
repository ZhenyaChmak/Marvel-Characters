package com.example.marvelcharacters.adapter.comics

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.marvelcharacters.databinding.FragmentCharacterComicsBinding
import com.example.marvelcharacters.domain.model.Comics

class ComicsAdapter(
    context: Context,
    private val onClickedComics: (Comics) -> Unit
) : ListAdapter<Comics, ComicsViewHolder>(DIFF_UTIL) {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        return ComicsViewHolder(
            binding = FragmentCharacterComicsBinding.inflate(layoutInflater, parent, false),
            onClickedComics = onClickedComics
        )
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {

        private val DIFF_UTIL = object : DiffUtil.ItemCallback<Comics>() {
            override fun areItemsTheSame(
                oldItem: Comics,
                newItem: Comics
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: Comics,
                newItem: Comics
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

}