package com.example.marvelcharacters.adapter.series

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.marvelcharacters.databinding.FragmentCharacterSeriesBinding
import com.example.marvelcharacters.domain.model.Series

class SeriesViewHolder(
    private val binding: FragmentCharacterSeriesBinding,
    private val onClickedSeries: (Series) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(series: Series) {
        with(binding) {

            photoSeries.load(series.photoSeries)

            root.setOnClickListener {
                onClickedSeries(series)
            }
        }
    }

}