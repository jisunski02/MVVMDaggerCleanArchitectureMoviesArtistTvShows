package com.jisunski.moviesmvvm.presentation.dependencyinjection.artist

import com.jisunski.moviesmvvm.data.domain.usecase.GetArtistsUseCase
import com.jisunski.moviesmvvm.data.domain.usecase.UpdateArtistUseCase
import com.jisunski.moviesmvvm.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ): ArtistViewModelFactory{
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistUseCase
        )
    }
}