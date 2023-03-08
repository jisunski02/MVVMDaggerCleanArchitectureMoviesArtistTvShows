package com.jisunski.moviesmvvm.presentation.dependencyinjection.core

import com.jisunski.moviesmvvm.data.repository.artist.datasource.ArtistCacheDatasource
import com.jisunski.moviesmvvm.data.repository.artist.datasourceimpl.ArtistCacheDatasourceImpl
import com.jisunski.moviesmvvm.data.repository.movie.datasource.MovieCacheDatasource
import com.jisunski.moviesmvvm.data.repository.movie.datasourceimpl.MovieCacheDatasourceImpl
import com.jisunski.moviesmvvm.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.jisunski.moviesmvvm.data.repository.tvshow.datasourceimpl.TvShowCacheDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDatasource{
        return MovieCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDatasource{
        return TvShowCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDatasource{
        return ArtistCacheDatasourceImpl()
    }
}