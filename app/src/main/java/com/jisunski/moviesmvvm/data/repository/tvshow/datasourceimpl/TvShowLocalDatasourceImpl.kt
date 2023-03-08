package com.jisunski.moviesmvvm.data.repository.tvshow.datasourceimpl

import com.jisunski.moviesmvvm.data.db.TvShowDao
import com.jisunski.moviesmvvm.data.model.tvshow.TvShow
import com.jisunski.moviesmvvm.data.repository.tvshow.datasource.TvShowLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDatasourceImpl(private val tvShowDao: TvShowDao): TvShowLocalDatasource {

    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }


}