package com.example.marvelcharacters.ui

import android.os.Bundle
import com.example.marvelcharacters.domain.model.Comics
import com.example.marvelcharacters.domain.model.Events
import com.example.marvelcharacters.domain.model.Series

fun showDetailsSeries(s: Series): CustomDialogFragment {
    val dialog = CustomDialogFragment()
    val args = Bundle().apply {
        putString("name", s.title)
        putString("photo", s.photoSeries)
        putString("description", s.description)
    }
    dialog.arguments = args

    return dialog
}

fun showDetailsComics(com: Comics): CustomDialogFragment {
    val dialog = CustomDialogFragment()
    val args = Bundle().apply {
        putString("name", com.title)
        putString("photo", com.photoComics)
        putString("description", com.description)
    }
    dialog.arguments = args

    return dialog
}

fun showDetailsEvents(events: Events): CustomDialogFragment {
    val dialog = CustomDialogFragment()
    val args = Bundle().apply {
        putString("name", events.title)
        putString("photo", events.photoEvents)
        putString("description", events.description)
    }
    dialog.arguments = args

    return dialog
}
