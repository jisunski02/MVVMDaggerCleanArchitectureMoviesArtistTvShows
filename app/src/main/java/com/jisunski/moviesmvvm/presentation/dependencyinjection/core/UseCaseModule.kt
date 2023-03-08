package com.jisunski.moviesmvvm.presentation.dependencyinjection.core

import com.jisunski.moviesmvvm.data.domain.repository.ArtistRepository
import com.jisunski.moviesmvvm.data.domain.repository.MovieRepository
import com.jisunski.moviesmvvm.data.domain.repository.TvShowRepository
import com.jisunski.moviesmvvm.data.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMovieUseCase{
        return UpdateMovieUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase{
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowUseCase{
        return UpdateTvShowUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistsUseCase{
        return GetArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistUseCase{
        return UpdateArtistUseCase(artistRepository)
    }
}