package com.jisunski.moviesmvvm.data.repository.tvshow

import android.util.Log
import com.jisunski.moviesmvvm.data.domain.repository.TvShowRepository
import com.jisunski.moviesmvvm.data.model.tvshow.TvShow
import com.jisunski.moviesmvvm.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.jisunski.moviesmvvm.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.jisunski.moviesmvvm.data.repository.tvshow.datasource.TvShowRemoteDatasource

class TvShowRepositoryImpl(
        private val tvShowRemoteDatasource: TvShowRemoteDatasource,
        private val tvShowLocalDatasource: TvShowLocalDatasource,
        private val tvShowCacheDatasource: TvShowCacheDatasource
): TvShowRepository {


    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {

        val newListOfTvShows = getTvShowFromAPI()
        tvShowLocalDatasource.clearAll()
        tvShowLocalDatasource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDatasource.saveTvShowToCache(newListOfTvShows)

        return newListOfTvShows
    }

    suspend fun getTvShowFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            val response = tvShowRemoteDatasource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }
        } catch (exception: Exception) {
            Log.i("", exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowLocalDatasource.getTvShowsFromDB()
        } catch (exception: Exception) {
            Log.i("", exception.message.toString())
        }

        if(tvShowList.isNotEmpty()){
            return tvShowList
        }
        else{
            //if movie list is empty get movie from API
            tvShowList = getTvShowFromAPI()
            //then save it to local database
            tvShowLocalDatasource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList

    }

    suspend fun getTvShowFromCache(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowCacheDatasource.getTvShowFromCache()
        }
        catch (exception: Exception){
            Log.i("",exception.message.toString())
        }

        if(tvShowList.isNotEmpty()){
            return tvShowList
        }
        else{
            //if movie list is empty get movie from local database
            tvShowList = getTvShowFromDB()
            //then save it to cache
            tvShowCacheDatasource.saveTvShowToCache(tvShowList)
        }

        return tvShowList

    }
}