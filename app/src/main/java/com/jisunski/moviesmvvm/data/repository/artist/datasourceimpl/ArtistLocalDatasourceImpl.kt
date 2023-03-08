package com.jisunski.moviesmvvm.data.repository.artist.datasourceimpl

import androidx.room.CoroutinesRoom
import com.jisunski.moviesmvvm.data.db.ArtistDao
import com.jisunski.moviesmvvm.data.db.MovieDao
import com.jisunski.moviesmvvm.data.model.artist.Artist
import com.jisunski.moviesmvvm.data.model.movie.Movie
import com.jisunski.moviesmvvm.data.repository.artist.datasource.ArtistLocalDatasource
import com.jisunski.moviesmvvm.data.repository.movie.datasource.MovieLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDatasourceImpl(private val artistDao: ArtistDao): ArtistLocalDatasource {

    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistsToDB(artist: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artist)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }

}