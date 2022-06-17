package com.example.marvelcharacters.di

import com.example.marvelcharacters.model.CharacterListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val characterViewModelModule = module {
    viewModelOf(::CharacterListViewModel)
}