package com.example.marvelcharacters.adapter.events

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.marvelcharacters.databinding.FragmentCharacterEventsBinding
import com.example.marvelcharacters.domain.model.Events

class EventsAdapter(
    context: Context,
    private val onClickedEvents: (Events) -> Unit
) : ListAdapter<Events, EventsVieHolder>(DIFF_UTIL) {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsVieHolder {
        return EventsVieHolder(
            FragmentCharacterEventsBinding.inflate(layoutInflater, parent, false),
            onClickedEvents = onClickedEvents
        )
    }

    override fun onBindViewHolder(holder: EventsVieHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<Events>() {
            override fun areItemsTheSame(oldItem: Events, newItem: Events): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Events, newItem: Events): Boolean {
                return oldItem == newItem
            }

        }
    }

}