package com.jisunski.moviesmvvm.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.jisunski.moviesmvvm.data.domain.usecase.GetTvShowsUseCase
import com.jisunski.moviesmvvm.data.domain.usecase.UpdateTvShowUseCase

class TvShowViewModel(
        private val getTvShowsUseCase: GetTvShowsUseCase,
        private val updateTvShowUseCase: UpdateTvShowUseCase
): ViewModel() {

    fun getTvShows() = liveData {
        val tvShowList = getTvShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData {
        val tvShowList = updateTvShowUseCase.execute()
        emit(tvShowList)
    }
}