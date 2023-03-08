package com.jisunski.moviesmvvm.data.repository.movie.datasource

import com.jisunski.moviesmvvm.data.model.movie.Movie

interface MovieLocalDatasource {

    //get Movies from DB
    suspend fun getMoviesFromDB(): List<Movie>
    //save list of movie instance to the DB
    suspend fun saveMoviesToDB(movie: List<Movie>)
    //clear the data in the DB table
    suspend fun clearAll()
}