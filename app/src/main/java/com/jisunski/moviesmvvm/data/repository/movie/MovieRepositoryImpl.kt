package com.jisunski.moviesmvvm.data.repository.movie

import android.util.Log
import com.jisunski.moviesmvvm.data.domain.repository.MovieRepository
import com.jisunski.moviesmvvm.data.model.movie.Movie
import com.jisunski.moviesmvvm.data.repository.movie.datasource.MovieCacheDatasource
import com.jisunski.moviesmvvm.data.repository.movie.datasource.MovieLocalDatasource
import com.jisunski.moviesmvvm.data.repository.movie.datasource.MovieRemoteDatasource

class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieLocalDatasource: MovieLocalDatasource,
    private val movieCacheDatasource: MovieCacheDatasource
): MovieRepository {

    override suspend fun getMovies(): List<Movie> {
        //if data not available in cache, it will get data from db, if not available in db, it will data from API
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie> {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDatasource.clearAll()
        movieLocalDatasource.saveMoviesToDB(newListOfMovies)
        movieCacheDatasource.saveMoviesToCache(newListOfMovies)

        return newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDatasource.getMovies()
            val body = response.body()
            if(body!=null){
                movieList = body.movies
            }
        } catch (exception: java.lang.Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDatasource.getMoviesFromDB()
        } catch (exception: java.lang.Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(movieList.size>0){
            return movieList
        }else{
            movieList=getMoviesFromAPI()
            movieLocalDatasource.saveMoviesToDB(movieList)
        }

        return movieList

    }

    suspend fun getMoviesFromCache(): List<Movie>{
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDatasource.getMoviesFromCache()
        }
        catch (exception: Exception){
            Log.i("",exception.message.toString())
        }

        if(movieList.size>0){
            return movieList
        }
        else{
            //if movie list is empty get movie from local database
            movieList = getMoviesFromDB()
            //then save it to cache
            movieCacheDatasource.saveMoviesToCache(movieList)
        }

        return movieList

    }
}