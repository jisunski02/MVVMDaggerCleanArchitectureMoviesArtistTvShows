package com.jisunski.moviesmvvm.data.repository.movie.datasource

import com.jisunski.moviesmvvm.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList>
}