package com.luluksofiyah.uas.utilities

import com.luluksofiyah.uas.data.model.Film
import com.luluksofiyah.uas.data.model.FilmType
import com.luluksofiyah.uas.data.source.local.entity.FilmEntity
import com.luluksofiyah.uas.data.source.remote.response.FilmItem


object DataMapper {
    fun mapFilmResponseToEntity(input: List<FilmItem>, filmType: FilmType): List<FilmEntity> =
        input.map {
            FilmEntity(
                id = it.id,
                overview = it.overview,
                backdropPath = it.backdropPath,
                posterPath = it.posterPath,
                originalLanguage = it.originalLanguage,
                releaseDate = it.releaseDate,
                voteCount = it.voteCount,
                voteAverage = it.voteAverage,
                genreIds = it.genreIds,
                filmType = filmType.name,
                title = it.title
            )
        }
    fun mapMovieEntitiesToMovieModel(input: List<FilmEntity>): List<Film> =
        input.map {
            Film(
                id = it.id,
                overview = it.overview,
                backdropPath = it.backdropPath,
                posterPath = it.posterPath,
                originalLanguage = it.originalLanguage,
                releaseDate = it.releaseDate,
                voteCount = it.voteCount,
                voteAverage = it.voteAverage,
                genreIds = it.genreIds,
                movieType = it.filmType,
                title = it.title,
            )
        }

    fun mapMovieEntityToMovieModel(input: FilmEntity): Film =
        input.let {
            Film(
                id = it.id,
                overview = it.overview,
                backdropPath = it.backdropPath,
                posterPath = it.posterPath,
                originalLanguage = it.originalLanguage,
                releaseDate = it.releaseDate,
                voteCount = it.voteCount,
                voteAverage = it.voteAverage,
                genreIds = it.genreIds,
                movieType = it.filmType,
                title = it.title,
            )
        }

    fun mapGenreIdToGenre(id: List<Int?>): List<String?> =
        id.map { genre ->
            when (genre) {
                28 -> "Action"
                12 -> "Adventure"
                16 -> "Animation"
                35 -> "Comedy"
                80 -> "Crime"
                99 -> "Documentary"
                18 -> "Drama"
                10751 -> "Family"
                14 -> "Fantasy"
                36 -> "History"
                27 -> "Horror"
                10402 -> "Music"
                9648 -> "Mystery"
                10749 -> "Romance"
                878 -> "Science Fiction"
                10770 -> "TV Movie"
                53 -> "Thriller"
                10752 -> "War"
                37 -> "Western"
                else -> null
            }
        }

}