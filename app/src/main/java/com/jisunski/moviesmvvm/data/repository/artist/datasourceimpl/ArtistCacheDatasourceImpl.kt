package com.jisunski.moviesmvvm.data.repository.artist.datasourceimpl

import com.jisunski.moviesmvvm.data.model.artist.Artist
import com.jisunski.moviesmvvm.data.repository.artist.datasource.ArtistCacheDatasource

class ArtistCacheDatasourceImpl: ArtistCacheDatasource {
    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }


}