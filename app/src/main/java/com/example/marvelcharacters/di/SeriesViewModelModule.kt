package com.example.marvelcharacters.di

import com.example.marvelcharacters.model.SeriesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val seriesViewModelModule = module {
    viewModelOf(::SeriesListViewModel )
}