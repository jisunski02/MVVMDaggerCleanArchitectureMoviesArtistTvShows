package com.jisunski.moviesmvvm.data.repository.artist.datasourceimpl

import com.jisunski.moviesmvvm.data.api.TMDBService
import com.jisunski.moviesmvvm.data.model.artist.ArtistList
import com.jisunski.moviesmvvm.data.model.movie.MovieList
import com.jisunski.moviesmvvm.data.repository.artist.datasource.ArtistRemoteDatasource
import com.jisunski.moviesmvvm.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class ArtistRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
    ): ArtistRemoteDatasource {

    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)


}