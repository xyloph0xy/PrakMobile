package com.luluksofiyah.uas.ui.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luluksofiyah.uas.data.Resource
import com.luluksofiyah.uas.data.model.Film
import com.luluksofiyah.uas.data.repository.FilmRespository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailVM @Inject constructor(private val filmRepository: FilmRespository) :
    ViewModel(){
    private val _detailMovie = MutableStateFlow<Resource<Film>>(Resource.Loading())
    val detailMovie: StateFlow<Resource<Film>> get() = _detailMovie

    fun getFavoriteMovies(movieId: Int) = viewModelScope.launch {
        filmRepository.getMovieById(movieId).collect {
            _detailMovie.value = it
        }
    }

    fun toggleFavorite(movieId: Int, isFavorite: Boolean) = viewModelScope.launch {
        filmRepository.updateMovieById(movieId, isFavorite)
    }
}