package com.jisunski.moviesmvvm.presentation.dependencyinjection.artist

import com.jisunski.moviesmvvm.presentation.artist.ArtistActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubcomponent {

    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): ArtistSubcomponent
    }
}