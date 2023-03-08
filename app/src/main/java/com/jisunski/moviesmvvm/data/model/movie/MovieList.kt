package com.jisunski.moviesmvvm.data.model.movie


import com.google.gson.annotations.SerializedName
import com.jisunski.moviesmvvm.data.model.movie.Movie

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)