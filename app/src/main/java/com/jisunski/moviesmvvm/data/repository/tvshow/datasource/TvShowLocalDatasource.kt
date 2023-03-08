package com.jisunski.moviesmvvm.data.repository.tvshow.datasource

import com.jisunski.moviesmvvm.data.model.tvshow.TvShow

interface TvShowLocalDatasource {

    //get TvShow from DB
    suspend fun getTvShowsFromDB(): List<TvShow>
    //save list of tv show instance to the DB
    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)
    //clear the data in the DB table
    suspend fun clearAll()
}