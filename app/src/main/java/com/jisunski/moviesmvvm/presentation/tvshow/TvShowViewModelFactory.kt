package com.jisunski.moviesmvvm.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jisunski.moviesmvvm.data.domain.usecase.GetMoviesUseCase
import com.jisunski.moviesmvvm.data.domain.usecase.GetTvShowsUseCase
import com.jisunski.moviesmvvm.data.domain.usecase.UpdateMovieUseCase
import com.jisunski.moviesmvvm.data.domain.usecase.UpdateTvShowUseCase

class TvShowViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowsUseCase, updateTvShowUseCase) as T
    }

}