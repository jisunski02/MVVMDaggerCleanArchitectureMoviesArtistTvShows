package com.jisunski.moviesmvvm.data.repository.tvshow.datasource

import com.jisunski.moviesmvvm.data.model.tvshow.TvShow

interface TvShowCacheDatasource {
    suspend fun getTvShowFromCache(): List<TvShow>
    suspend fun saveTvShowToCache(tvShows:List<TvShow>)
}