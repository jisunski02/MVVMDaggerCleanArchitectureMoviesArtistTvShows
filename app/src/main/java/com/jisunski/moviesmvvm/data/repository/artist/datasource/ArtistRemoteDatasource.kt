package com.jisunski.moviesmvvm.data.repository.artist.datasource

import com.jisunski.moviesmvvm.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {
    suspend fun getArtists(): Response<ArtistList>
}