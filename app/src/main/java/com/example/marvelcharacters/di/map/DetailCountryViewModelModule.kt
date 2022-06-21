package com.example.marvelcharacters.di.map

import com.example.marvelcharacters.model.map.DetailsCountryViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val detailsCountryViewModelModule = module {

    viewModelOf(::DetailsCountryViewModel)

}