package com.example.marvelcharacters.model

sealed class Lce<out T> {

    data class Element<T>(val data: T) : Lce<T>()

    object Loading : Lce<Nothing>()

   /* data class Error(val thr: Throwable) : Lce<Nothing>()*/

}
