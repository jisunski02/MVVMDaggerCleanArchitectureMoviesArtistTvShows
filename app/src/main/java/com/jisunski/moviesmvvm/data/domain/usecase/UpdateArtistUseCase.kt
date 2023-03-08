package com.jisunski.moviesmvvm.data.domain.usecase

import com.jisunski.moviesmvvm.data.domain.repository.ArtistRepository
import com.jisunski.moviesmvvm.data.model.artist.Artist

//ViewModel class will call to this to get List of movies but this use case doesnt know anything about the repository
class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()

}