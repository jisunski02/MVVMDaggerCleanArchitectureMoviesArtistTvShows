package com.jisunski.moviesmvvm.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jisunski.moviesmvvm.data.model.artist.Artist
import com.jisunski.moviesmvvm.data.model.movie.Movie
import com.jisunski.moviesmvvm.data.model.tvshow.TvShow
import dagger.Provides
import javax.inject.Singleton

@Database(entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase(){
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvShowDao
    abstract fun artistDao(): ArtistDao

}