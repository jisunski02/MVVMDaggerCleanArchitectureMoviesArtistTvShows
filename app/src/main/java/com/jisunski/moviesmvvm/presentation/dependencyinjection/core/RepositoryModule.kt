package com.jisunski.moviesmvvm.presentation.dependencyinjection.core

import com.jisunski.moviesmvvm.data.domain.repository.ArtistRepository
import com.jisunski.moviesmvvm.data.domain.repository.MovieRepository
import com.jisunski.moviesmvvm.data.domain.repository.TvShowRepository
import com.jisunski.moviesmvvm.data.repository.artist.ArtistRepositoryImpl
import com.jisunski.moviesmvvm.data.repository.artist.datasource.ArtistCacheDatasource
import com.jisunski.moviesmvvm.data.repository.artist.datasource.ArtistLocalDatasource
import com.jisunski.moviesmvvm.data.repository.artist.datasource.ArtistRemoteDatasource
import com.jisunski.moviesmvvm.data.repository.movie.MovieRepositoryImpl
import com.jisunski.moviesmvvm.data.repository.movie.datasource.MovieCacheDatasource
import com.jisunski.moviesmvvm.data.repository.movie.datasource.MovieLocalDatasource
import com.jisunski.moviesmvvm.data.repository.movie.datasource.MovieRemoteDatasource
import com.jisunski.moviesmvvm.data.repository.tvshow.TvShowRepositoryImpl
import com.jisunski.moviesmvvm.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.jisunski.moviesmvvm.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.jisunski.moviesmvvm.data.repository.tvshow.datasource.TvShowRemoteDatasource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDatasource: MovieLocalDatasource,
        movieCacheDatasource: MovieCacheDatasource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDatasource,
            movieCacheDatasource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
       artistRemoteDatasource: ArtistRemoteDatasource,
       artistLocalDatasource: ArtistLocalDatasource,
       artistCacheDatasource: ArtistCacheDatasource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDatasource,
            artistCacheDatasource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDatasource: TvShowLocalDatasource,
        tvShowCacheDatasource: TvShowCacheDatasource
    ): TvShowRepository {

        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDatasource,
            tvShowCacheDatasource
        )
    }
}