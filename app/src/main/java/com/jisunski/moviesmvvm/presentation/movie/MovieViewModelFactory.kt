package com.jisunski.moviesmvvm.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jisunski.moviesmvvm.data.domain.usecase.GetMoviesUseCase
import com.jisunski.moviesmvvm.data.domain.usecase.UpdateMovieUseCase

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUseCase, updateMovieUseCase) as T
    }

}