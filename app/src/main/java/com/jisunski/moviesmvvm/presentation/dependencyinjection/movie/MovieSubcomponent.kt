package com.jisunski.moviesmvvm.presentation.dependencyinjection.movie

import com.jisunski.moviesmvvm.presentation.artist.ArtistActivity
import com.jisunski.moviesmvvm.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubcomponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieSubcomponent
    }
}