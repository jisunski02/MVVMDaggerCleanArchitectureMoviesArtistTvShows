package com.jisunski.moviesmvvm.data.repository.movie.datasourceimpl

import com.jisunski.moviesmvvm.data.db.MovieDao
import com.jisunski.moviesmvvm.data.model.movie.Movie
import com.jisunski.moviesmvvm.data.repository.movie.datasource.MovieLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDatasourceImpl(private val movieDao: MovieDao): MovieLocalDatasource {
    override suspend fun getMoviesFromDB(): List<Movie> {
       return movieDao.getMovies()
    }

    override suspend fun saveMoviesToDB(movie: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movie)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}