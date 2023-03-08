package com.jisunski.moviesmvvm.presentation.dependencyinjection.tvshow

import com.jisunski.moviesmvvm.data.domain.usecase.GetMoviesUseCase
import com.jisunski.moviesmvvm.data.domain.usecase.GetTvShowsUseCase
import com.jisunski.moviesmvvm.data.domain.usecase.UpdateMovieUseCase
import com.jisunski.moviesmvvm.data.domain.usecase.UpdateTvShowUseCase
import com.jisunski.moviesmvvm.presentation.movie.MovieViewModelFactory
import com.jisunski.moviesmvvm.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideMovieViewModelFactory(
       getTvShowsUseCase: GetTvShowsUseCase,
       updateTvShowUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory{
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowUseCase
        )
    }
}