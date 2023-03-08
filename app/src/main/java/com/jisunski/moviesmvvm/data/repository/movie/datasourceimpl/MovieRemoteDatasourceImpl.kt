package com.jisunski.moviesmvvm.data.repository.movie.datasourceimpl

import com.jisunski.moviesmvvm.data.api.TMDBService
import com.jisunski.moviesmvvm.data.model.movie.MovieList
import com.jisunski.moviesmvvm.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
    ): MovieRemoteDatasource {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}