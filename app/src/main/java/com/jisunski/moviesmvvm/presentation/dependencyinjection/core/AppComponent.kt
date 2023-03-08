package com.jisunski.moviesmvvm.presentation.dependencyinjection.core

import com.jisunski.moviesmvvm.presentation.dependencyinjection.artist.ArtistSubcomponent
import com.jisunski.moviesmvvm.presentation.dependencyinjection.movie.MovieSubcomponent
import com.jisunski.moviesmvvm.presentation.dependencyinjection.tvshow.TvShowSubcomponent
import dagger.Component
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DatabaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {

    fun movieSubComponent(): MovieSubcomponent.Factory
    fun artistSubComponent(): ArtistSubcomponent.Factory
    fun tvShowSubComponent(): TvShowSubcomponent.Factory
}