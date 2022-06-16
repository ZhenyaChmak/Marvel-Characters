package com.example.marvelcharacters.di.details

import com.example.marvelcharacters.model.detais.SeriesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val seriesViewModelModule = module {
    viewModelOf(::SeriesListViewModel )
}