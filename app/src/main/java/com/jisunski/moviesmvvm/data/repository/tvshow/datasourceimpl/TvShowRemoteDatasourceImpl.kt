package com.jisunski.moviesmvvm.data.repository.tvshow.datasourceimpl

import com.jisunski.moviesmvvm.data.api.TMDBService
import com.jisunski.moviesmvvm.data.model.artist.ArtistList
import com.jisunski.moviesmvvm.data.model.movie.MovieList
import com.jisunski.moviesmvvm.data.model.tvshow.TvShowList
import com.jisunski.moviesmvvm.data.repository.artist.datasource.ArtistRemoteDatasource
import com.jisunski.moviesmvvm.data.repository.movie.datasource.MovieRemoteDatasource
import com.jisunski.moviesmvvm.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
    ): TvShowRemoteDatasource {


    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)


}