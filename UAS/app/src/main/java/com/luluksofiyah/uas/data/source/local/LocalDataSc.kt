package com.luluksofiyah.uas.data.source.local

import com.luluksofiyah.uas.data.source.local.entity.FilmEntity
import com.luluksofiyah.uas.data.source.local.room.FilmGet
import javax.inject.Inject

class LocalDataSc @Inject constructor(
    private val getFilm: FilmGet
) {
    suspend fun insertMovies(movies: List<FilmEntity>) = getFilm.insertMovies(movies)

    fun getMovies(type: String) = getFilm.getMovies(type)



    fun getMovieById(moovId: Int) = getFilm.getMovieById(moovId)


}