package com.jisunski.moviesmvvm.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.jisunski.moviesmvvm.data.domain.usecase.GetMoviesUseCase
import com.jisunski.moviesmvvm.data.domain.usecase.UpdateMovieUseCase

class MovieViewModel(
        private val getMoviesUseCase: GetMoviesUseCase,
        private val updateMovieUseCase: UpdateMovieUseCase
): ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMovieUseCase.execute()
        emit(movieList)
    }
}