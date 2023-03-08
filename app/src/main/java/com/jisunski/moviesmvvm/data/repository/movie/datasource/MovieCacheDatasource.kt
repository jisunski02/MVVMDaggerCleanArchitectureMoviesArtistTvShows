package com.jisunski.moviesmvvm.data.repository.movie.datasource

import com.jisunski.moviesmvvm.data.model.movie.Movie

interface MovieCacheDatasource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)
}