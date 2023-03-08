package com.jisunski.moviesmvvm.data.repository.artist.datasource

import com.jisunski.moviesmvvm.data.model.artist.Artist

interface ArtistCacheDatasource {
    suspend fun getArtistFromCache(): List<Artist>
    suspend fun saveArtistToCache(artist:List<Artist>)
}