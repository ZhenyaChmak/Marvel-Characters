package com.example.marvelcharacters.adapter.series

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.marvelcharacters.databinding.FragmentCharacterBinding
import com.example.marvelcharacters.databinding.FragmentDetailsCharacterBinding
import com.example.marvelcharacters.databinding.FragmentSeriesBinding
import com.example.marvelcharacters.domain.model.Character
import com.example.marvelcharacters.domain.model.Series

class SeriesViewHolder(
    private val binding: FragmentSeriesBinding,
    private val onClickedCharacter: (Series) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(series: Series) {
        with(binding) {
            photoSeries.load(series.photoSeries)

            root.setOnClickListener {
                onClickedCharacter(series)
            }
        }
    }
}