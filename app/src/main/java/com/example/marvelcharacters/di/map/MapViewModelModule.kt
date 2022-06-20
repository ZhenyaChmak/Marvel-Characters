package com.example.marvelcharacters.di.map

import com.example.marvelcharacters.model.map.MapViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val mapViewModelModule = module {

    viewModelOf(::MapViewModel)

}