package com.jisunski.moviesmvvm.data.repository.tvshow.datasource

import com.jisunski.moviesmvvm.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
    suspend fun getTvShows(): Response<TvShowList>
}