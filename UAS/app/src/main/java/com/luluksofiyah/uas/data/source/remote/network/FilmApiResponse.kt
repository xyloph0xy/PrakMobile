package com.luluksofiyah.uas.data.source.remote.network

sealed class FilmApiResponse <out R> {
    data class Success<out T>(val data: T) : FilmApiResponse<T>()
    data class Error(val errorMessage: String) : FilmApiResponse<Nothing>()
    object Empty : FilmApiResponse<Nothing>()
}
