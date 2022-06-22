package com.example.marvelcharacters.ui.characters

import com.yarolegovich.discretescrollview.DiscreteScrollView
import com.yarolegovich.discretescrollview.transform.ScaleTransformer

fun scrollView(
    view: DiscreteScrollView
) {

    view.setSlideOnFlingThreshold(3000)

    view.setSlideOnFling(true)

    view.setItemTransformer(
        ScaleTransformer.Builder()
            .setMaxScale(1.2f)
            .setMinScale(0.7f)
            .build()
    )

}