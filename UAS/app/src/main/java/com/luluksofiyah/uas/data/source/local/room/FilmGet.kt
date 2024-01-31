package com.luluksofiyah.uas.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.luluksofiyah.uas.data.source.local.entity.FilmEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmGet {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<FilmEntity>)

    @Query("SELECT * FROM film WHERE filmType = :filmType")
    fun getMovies(filmType: String): Flow<List<FilmEntity>>

    @Query("SELECT * FROM film WHERE id=:filmId ORDER BY id")
    fun getMovieById(filmId: Int): Flow<FilmEntity>

}