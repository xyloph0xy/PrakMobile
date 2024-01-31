package com.luluksofiyah.uas.data.source.remote

import com.luluksofiyah.uas.data.source.remote.network.FilmApiResponse
import com.luluksofiyah.uas.data.source.remote.network.FilmApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteDataSc @Inject constructor(
    private val filmApiService: FilmApiService
) {
    suspend fun getPopularMovies() = flow {
        try {
            val response = filmApiService.getPopularMovies()
            val data = response.results
            if (data.isNotEmpty()) emit(FilmApiResponse.Success(data))
            else emit(FilmApiResponse.Empty)
        } catch (e: Exception) {
            emit(FilmApiResponse.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    suspend fun getUpcomingMovies() = flow {
        try {
            val response = filmApiService.getUpcomingMovies()
            val data = response.results
            if (data.isNotEmpty()) emit(FilmApiResponse.Success(data))
            else (emit(FilmApiResponse.Empty))
        } catch (e: Exception) {
            emit(FilmApiResponse.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}