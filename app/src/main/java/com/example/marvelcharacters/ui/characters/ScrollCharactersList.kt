package com.example.marvelcharacters.ui

import com.example.marvelcharacters.adapter.character.CharacterAdapter
import com.yarolegovich.discretescrollview.DiscreteScrollView
import com.yarolegovich.discretescrollview.transform.ScaleTransformer

fun scrollView(
    view: DiscreteScrollView,
    adapter: CharacterAdapter
) {

    view.adapter = adapter

    view.setSlideOnFlingThreshold(1200)

    view.setItemTransformer(
        ScaleTransformer.Builder()
            .setMaxScale(1.2f)
            .setMinScale(0.7f)
            .build()
    )
}