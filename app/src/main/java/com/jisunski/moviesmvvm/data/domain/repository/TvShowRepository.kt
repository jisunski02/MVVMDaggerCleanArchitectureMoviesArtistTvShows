package com.jisunski.moviesmvvm.data.domain.repository

import com.jisunski.moviesmvvm.data.model.tvshow.TvShow

//Requirement for TvShowUseCase
interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?


}