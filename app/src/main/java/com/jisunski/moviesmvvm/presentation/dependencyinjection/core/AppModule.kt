package com.jisunski.moviesmvvm.presentation.dependencyinjection.core

import android.content.Context
import com.jisunski.moviesmvvm.presentation.dependencyinjection.artist.ArtistSubcomponent
import com.jisunski.moviesmvvm.presentation.dependencyinjection.movie.MovieSubcomponent
import com.jisunski.moviesmvvm.presentation.dependencyinjection.tvshow.TvShowSubcomponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubcomponent::class, TvShowSubcomponent::class, ArtistSubcomponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context{
        return context.applicationContext
    }
}