package com.jisunski.moviesmvvm.presentation.dependencyinjection.tvshow

import com.jisunski.moviesmvvm.presentation.artist.ArtistActivity
import com.jisunski.moviesmvvm.presentation.movie.MovieActivity
import com.jisunski.moviesmvvm.presentation.tvshow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubcomponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubcomponent
    }
}