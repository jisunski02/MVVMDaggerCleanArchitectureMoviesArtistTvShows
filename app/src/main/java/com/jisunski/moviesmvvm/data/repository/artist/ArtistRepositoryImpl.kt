package com.jisunski.moviesmvvm.data.repository.artist

import android.util.Log
import com.jisunski.moviesmvvm.data.domain.repository.ArtistRepository
import com.jisunski.moviesmvvm.data.model.artist.Artist
import com.jisunski.moviesmvvm.data.repository.artist.datasource.ArtistCacheDatasource
import com.jisunski.moviesmvvm.data.repository.artist.datasource.ArtistLocalDatasource
import com.jisunski.moviesmvvm.data.repository.artist.datasource.ArtistRemoteDatasource

class ArtistRepositoryImpl(
        private val artistRemoteDatasource: ArtistRemoteDatasource,
        private val artistLocalDatasource: ArtistLocalDatasource,
        private val artistCacheDatasource: ArtistCacheDatasource
): ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {

        val newListOfArtists = getArtistFromAPI()
        artistLocalDatasource.clearAll()
        artistLocalDatasource.saveArtistsToDB(newListOfArtists)
        artistCacheDatasource.saveArtistToCache(newListOfArtists)

        return newListOfArtists
    }

    suspend fun getArtistFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDatasource.getArtists()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (exception: Exception) {
            Log.i("", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistLocalDatasource.getArtistsFromDB()
        } catch (exception: Exception) {
            Log.i("", exception.message.toString())
        }

        if(artistList.isNotEmpty()){
            return artistList
        }
        else{
            //if movie list is empty get movie from API
            artistList = getArtistFromAPI()
            //then save it to local database
            artistLocalDatasource.saveArtistsToDB(artistList)
        }
        return artistList

    }

    suspend fun getArtistFromCache(): List<Artist>{
        lateinit var artistList: List<Artist>

        try {
            artistList = artistCacheDatasource.getArtistFromCache()
        }
        catch (exception: Exception){
            Log.i("",exception.message.toString())
        }

        if(artistList.isNotEmpty()){
            return artistList
        }
        else{
            //if movie list is empty get movie from local database
            artistList = getArtistFromDB()
            //then save it to cache
            artistCacheDatasource.saveArtistToCache(artistList)
        }

        return artistList

    }
}