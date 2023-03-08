package com.jisunski.moviesmvvm.presentation.dependencyinjection.core

import com.jisunski.moviesmvvm.data.api.TMDBService
import com.jisunski.moviesmvvm.data.repository.artist.datasource.ArtistRemoteDatasource
import com.jisunski.moviesmvvm.data.repository.artist.datasourceimpl.ArtistRemoteDatasourceImpl
import com.jisunski.moviesmvvm.data.repository.movie.datasource.MovieRemoteDatasource
import com.jisunski.moviesmvvm.data.repository.movie.datasourceimpl.MovieRemoteDatasourceImpl
import com.jisunski.moviesmvvm.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.jisunski.moviesmvvm.data.repository.tvshow.datasourceimpl.TvShowRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDatasource{
        return MovieRemoteDatasourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDatasource{
        return TvShowRemoteDatasourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDatasource{
        return ArtistRemoteDatasourceImpl(
            tmdbService, apiKey
        )
    }
}