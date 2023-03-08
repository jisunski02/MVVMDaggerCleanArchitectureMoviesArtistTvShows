package com.jisunski.moviesmvvm.data.domain.usecase

import com.jisunski.moviesmvvm.data.domain.repository.TvShowRepository
import com.jisunski.moviesmvvm.data.model.tvshow.TvShow

//ViewModel class will call to this to get List of movies but this use case doesnt know anything about the repository
class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()
}