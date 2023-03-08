package com.jisunski.moviesmvvm.data.domain.usecase

import com.jisunski.moviesmvvm.data.domain.repository.MovieRepository
import com.jisunski.moviesmvvm.data.model.movie.Movie

//ViewModel class will call to this to get List of movies but this use case doesnt know anything about the repository
class UpdateMovieUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}