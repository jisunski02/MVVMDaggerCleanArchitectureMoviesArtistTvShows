package com.jisunski.moviesmvvm.presentation.dependencyinjection.movie

import com.jisunski.moviesmvvm.data.domain.usecase.GetMoviesUseCase
import com.jisunski.moviesmvvm.data.domain.usecase.UpdateMovieUseCase
import com.jisunski.moviesmvvm.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMovieUseCase: UpdateMovieUseCase
    ): MovieViewModelFactory{
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMovieUseCase
        )
    }
}