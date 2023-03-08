package com.jisunski.moviesmvvm.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jisunski.moviesmvvm.data.domain.usecase.GetArtistsUseCase
import com.jisunski.moviesmvvm.data.domain.usecase.GetMoviesUseCase
import com.jisunski.moviesmvvm.data.domain.usecase.UpdateArtistUseCase
import com.jisunski.moviesmvvm.data.domain.usecase.UpdateMovieUseCase

class ArtistViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUseCase, updateArtistUseCase) as T
    }

}