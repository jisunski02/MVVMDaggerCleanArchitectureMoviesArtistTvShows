package com.jisunski.moviesmvvm.data.repository.tvshow.datasourceimpl

import com.jisunski.moviesmvvm.data.model.artist.Artist
import com.jisunski.moviesmvvm.data.model.tvshow.TvShow
import com.jisunski.moviesmvvm.data.model.tvshow.TvShowList
import com.jisunski.moviesmvvm.data.repository.tvshow.datasource.TvShowCacheDatasource

class TvShowCacheDatasourceImpl: TvShowCacheDatasource {
    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)

    }


}