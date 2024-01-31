package com.luluksofiyah.uas.data.source.remote.network

import com.luluksofiyah.uas.data.source.remote.response.FilmResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): FilmResponse

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ):FilmResponse
}