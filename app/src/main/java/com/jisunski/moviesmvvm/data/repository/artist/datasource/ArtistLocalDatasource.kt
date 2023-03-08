package com.jisunski.moviesmvvm.data.repository.artist.datasource

import com.jisunski.moviesmvvm.data.model.artist.Artist

interface ArtistLocalDatasource {

    //get artist from DB
    suspend fun getArtistsFromDB(): List<Artist>
    //save list of artist instance to the DB
    suspend fun saveArtistsToDB(artist: List<Artist>)
    //clear the data in the DB table
    suspend fun clearAll()
}