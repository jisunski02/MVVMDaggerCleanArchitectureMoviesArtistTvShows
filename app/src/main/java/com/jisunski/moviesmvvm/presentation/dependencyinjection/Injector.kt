package com.jisunski.moviesmvvm.presentation.dependencyinjection

import com.jisunski.moviesmvvm.presentation.dependencyinjection.artist.ArtistSubcomponent
import com.jisunski.moviesmvvm.presentation.dependencyinjection.movie.MovieSubcomponent
import com.jisunski.moviesmvvm.presentation.dependencyinjection.tvshow.TvShowSubcomponent

interface Injector {
    fun createMovieSubComponent(): MovieSubcomponent
    fun createArtistSubComponent(): ArtistSubcomponent
    fun createTvShowSubComponent(): TvShowSubcomponent
}