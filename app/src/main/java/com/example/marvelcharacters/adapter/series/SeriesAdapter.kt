package com.example.marvelcharacters.adapter.series

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.marvelcharacters.databinding.FragmentCharacterSeriesBinding
import com.example.marvelcharacters.domain.model.Series

class SeriesAdapter(
    context: Context,
    private val onClickedSeries: (Series) -> Unit
) : ListAdapter<Series, SeriesViewHolder>(DIFF_UTIL) {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        return SeriesViewHolder(
            binding = FragmentCharacterSeriesBinding.inflate(layoutInflater, parent, false),
            onClickedSeries = onClickedSeries
        )
    }

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {

        private val DIFF_UTIL = object : DiffUtil.ItemCallback<Series>() {
            override fun areItemsTheSame(
                oldItem: Series,
                newItem: Series
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: Series,
                newItem: Series
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}