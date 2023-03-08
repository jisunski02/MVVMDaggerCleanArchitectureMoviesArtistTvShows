package com.jisunski.moviesmvvm.presentation.dependencyinjection.core

import android.content.Context
import androidx.room.Room
import com.jisunski.moviesmvvm.data.db.ArtistDao
import com.jisunski.moviesmvvm.data.db.MovieDao
import com.jisunski.moviesmvvm.data.db.TMDBDatabase
import com.jisunski.moviesmvvm.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): TMDBDatabase{
        return Room.databaseBuilder(context, TMDBDatabase::class.java,"tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao{
        return  tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDao{
        return  tmdbDatabase.tvDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao{
        return  tmdbDatabase.artistDao()
    }
}