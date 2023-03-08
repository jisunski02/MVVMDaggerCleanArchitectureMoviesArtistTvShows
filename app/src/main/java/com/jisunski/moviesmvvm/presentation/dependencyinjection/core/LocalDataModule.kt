package com.jisunski.moviesmvvm.presentation.dependencyinjection.core

import com.jisunski.moviesmvvm.data.db.ArtistDao
import com.jisunski.moviesmvvm.data.db.MovieDao
import com.jisunski.moviesmvvm.data.db.TvShowDao
import com.jisunski.moviesmvvm.data.repository.artist.datasource.ArtistLocalDatasource
import com.jisunski.moviesmvvm.data.repository.artist.datasourceimpl.ArtistLocalDatasourceImpl
import com.jisunski.moviesmvvm.data.repository.movie.datasource.MovieLocalDatasource
import com.jisunski.moviesmvvm.data.repository.movie.datasourceimpl.MovieLocalDatasourceImpl
import com.jisunski.moviesmvvm.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.jisunski.moviesmvvm.data.repository.tvshow.datasourceimpl.TvShowLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDatasource{
        return MovieLocalDatasourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDatasource{
        return ArtistLocalDatasourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDatasource{
        return TvShowLocalDatasourceImpl(tvShowDao)
    }
}