package com.luluksofiyah.uas.utilities

object Constants {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/original"
    private const val API_KEY =
        "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxNzMwY2NkYjg4NDhlOWVkMTBjZTcxNTMyZGU2NDliMiIsInN1YiI6IjY1YjllNWRkZmQ3YWE0MDE4NDhiNDY4ZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.rkEmr4olW9yS4-2EEb5SxJ0c608Iv4KSsJ3KpE5jBQ0"
    private const val BEARER = "Bearer "
    const val AUTHORIZATION = "Authorization"

    fun getBearer(): String {
        return BEARER + API_KEY
    }

    fun getImageUrl(path: String): String {
        return BASE_URL_IMAGE + path
    }

    const val DB_NAME = "Moov.db"
    const val DB_VERSION = 2
}