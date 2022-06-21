package com.example.marvelcharacters.di.details

import com.example.marvelcharacters.model.comics.ComicsListViewModel
import com.example.marvelcharacters.model.detais.SeriesListViewModel
import com.example.marvelcharacters.model.events.EventsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val detailsViewModelModule = module {

    viewModelOf(::SeriesListViewModel)

    viewModelOf(::ComicsListViewModel)

    viewModelOf(::EventsListViewModel)

}