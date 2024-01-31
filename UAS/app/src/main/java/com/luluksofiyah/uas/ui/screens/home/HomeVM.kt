package com.luluksofiyah.uas.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luluksofiyah.uas.data.Resource
import com.luluksofiyah.uas.data.model.Film
import com.luluksofiyah.uas.data.repository.FilmRespository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(private val movieRepository: FilmRespository) :
    ViewModel() {

    private val _popularMoviesState = MutableStateFlow<Resource<List<Film>>>(Resource.Loading())
    val popularMoviesState: StateFlow<Resource<List<Film>>> get() = _popularMoviesState

    private val _upcomingMoviesState = MutableStateFlow<Resource<List<Film>>>(Resource.Loading())
    val upcomingMoviesState: StateFlow<Resource<List<Film>>> get() = _upcomingMoviesState

    init {
        fetchPopularMovies()
        fetchUpcomingMovies()
    }

    private fun fetchPopularMovies() = viewModelScope.launch {
        movieRepository.getPopularMovies().collect { result ->
            _popularMoviesState.value = result
        }
    }

    private fun fetchUpcomingMovies() = viewModelScope.launch {
        movieRepository.getUpcomingMovies().collect { result ->
            _upcomingMoviesState.value = result
        }
    }
}