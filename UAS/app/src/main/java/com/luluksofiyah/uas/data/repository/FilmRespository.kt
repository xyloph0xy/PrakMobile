package com.luluksofiyah.uas.data.repository

import com.luluksofiyah.uas.data.FilmNetworkBoundResource
import com.luluksofiyah.uas.data.Resource
import com.luluksofiyah.uas.data.model.Film
import com.luluksofiyah.uas.data.model.FilmType
import com.luluksofiyah.uas.data.source.local.LocalDataSc
import com.luluksofiyah.uas.data.source.remote.RemoteDataSc
import com.luluksofiyah.uas.utilities.DataMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FilmRespository @Inject constructor(
    private val remote: RemoteDataSc,
    private val local: LocalDataSc
){
    fun getPopularMovies(): Flow<Resource<List<Film>>> = FilmNetworkBoundResource(
        query = {
            local.getMovies(FilmType.POPULAR.name).map {
                DataMapper.mapMovieEntitiesToMovieModel(it)
            }
        },
        fetch = {
            remote.getPopularMovies()
        },
        saveFetchResult = {
            val entity = DataMapper.mapFilmResponseToEntity(it, FilmType.POPULAR)
            local.insertMovies(entity)
        },
        shouldFetch = {
            it.isNullOrEmpty()
        }
    )

    fun getUpcomingMovies(): Flow<Resource<List<Film>>> = FilmNetworkBoundResource(
        query = {
            local.getMovies(FilmType.UPCOMING.name).map {
                DataMapper.mapMovieEntitiesToMovieModel(it)
            }
        },
        fetch = {
            remote.getUpcomingMovies()
        },
        saveFetchResult = {
            val entity = DataMapper.mapFilmResponseToEntity(it, FilmType.UPCOMING)
            local.insertMovies(entity)
        },
        shouldFetch = {
            it.isNullOrEmpty()
        }
    )



    fun getMovieById(moovId: Int): Flow<Resource<Film>> = flow {
        emit(Resource.Loading())
        try {
            val movieEntity = local.getMovieById(moovId).first()
            val movie = DataMapper.mapMovieEntityToMovieModel(movieEntity)
            emit(Resource.Success(movie))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message))
        }
    }.flowOn(Dispatchers.IO)


}