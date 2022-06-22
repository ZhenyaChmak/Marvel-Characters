package com.example.marvelcharacters.adapter.events

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.marvelcharacters.databinding.FragmentCharacterEventsBinding
import com.example.marvelcharacters.domain.model.Events

class EventsVieHolder(
    private val binding: FragmentCharacterEventsBinding,
    private val onClickedEvents: (Events) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(events: Events) {
        with(binding) {

            photoEvents.load(events.photoEvents)

            root.setOnClickListener {
                onClickedEvents(events)
            }
        }
    }

}