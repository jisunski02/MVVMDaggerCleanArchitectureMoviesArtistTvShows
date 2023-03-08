package com.jisunski.moviesmvvm.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.jisunski.moviesmvvm.data.domain.usecase.GetArtistsUseCase
import com.jisunski.moviesmvvm.data.domain.usecase.UpdateArtistUseCase

class ArtistViewModel(
        private val getArtistsUseCase: GetArtistsUseCase,
        private val updateArtistUseCase: UpdateArtistUseCase
): ViewModel() {

    fun getArtists() = liveData {
        val artistList = getArtistsUseCase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData {
        val artistList = updateArtistUseCase.execute()
        emit(artistList)
    }
}