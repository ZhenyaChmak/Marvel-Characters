package com.example.marvelcharacters.ui

import android.os.Bundle
import com.example.marvelcharacters.domain.model.Comics
import com.example.marvelcharacters.domain.model.Events
import com.example.marvelcharacters.domain.model.Series

fun showDetailsSeries(a: Series): CustomDialogFragment {
    val dialog = CustomDialogFragment()
    val args = Bundle().apply {
        putString("name", a.title)
        putString("photo", a.photoSeries)
        putString("description", a.description)
    }
    dialog.arguments = args

    return dialog
}

fun showDetailsComics(a: Comics): CustomDialogFragment {
    val dialog = CustomDialogFragment()
    val args = Bundle().apply {
        putString("name", a.title)
        putString("photo", a.photoComics)
        putString("description", a.description)
    }
    dialog.arguments = args

    return dialog
}

fun showDetailsEvents(a: Events): CustomDialogFragment {
    val dialog = CustomDialogFragment()
    val args = Bundle().apply {
        putString("name", a.title)
        putString("photo", a.photoEvents)
        putString("description", a.description)
    }
    dialog.arguments = args

    return dialog
}
