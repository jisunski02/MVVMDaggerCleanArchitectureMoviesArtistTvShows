package com.jisunski.moviesmvvm.data.model.tvshow


import com.google.gson.annotations.SerializedName
import com.jisunski.moviesmvvm.data.model.tvshow.TvShow

data class TvShowList(
    @SerializedName("results")
    val tvShows: List<TvShow>
)