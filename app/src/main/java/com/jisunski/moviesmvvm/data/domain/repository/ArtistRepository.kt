package com.jisunski.moviesmvvm.data.domain.repository

import com.jisunski.moviesmvvm.data.model.artist.Artist

//Requirement for ArtistUseCase
interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}