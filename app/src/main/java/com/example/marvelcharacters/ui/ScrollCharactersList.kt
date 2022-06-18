package com.example.marvelcharacters.ui

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelcharacters.adapter.character.CharacterAdapter
import com.yarolegovich.discretescrollview.DiscreteScrollView
import com.yarolegovich.discretescrollview.transform.ScaleTransformer

fun scrollView(
    view: DiscreteScrollView,
    adapter: CharacterAdapter
) {

    view.adapter = adapter

    view.setSlideOnFlingThreshold(1000)

    view.setSlideOnFling(true)

    view.setItemTransformer(
        ScaleTransformer.Builder()
            .setMaxScale(1.0f)
            .setMinScale(0.7f)
            .build()
    )
}