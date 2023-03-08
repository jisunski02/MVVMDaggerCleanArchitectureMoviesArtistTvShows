package com.jisunski.moviesmvvm.presentation

import android.app.Application
import android.os.Build
import com.jisunski.moviesmvvm.BuildConfig
import com.jisunski.moviesmvvm.presentation.dependencyinjection.Injector
import com.jisunski.moviesmvvm.presentation.dependencyinjection.artist.ArtistSubcomponent
import com.jisunski.moviesmvvm.presentation.dependencyinjection.core.*
import com.jisunski.moviesmvvm.presentation.dependencyinjection.movie.MovieSubcomponent
import com.jisunski.moviesmvvm.presentation.dependencyinjection.tvshow.TvShowSubcomponent

class App: Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubcomponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubcomponent {
        return appComponent.artistSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubcomponent {
        return appComponent.tvShowSubComponent().create()
    }
}