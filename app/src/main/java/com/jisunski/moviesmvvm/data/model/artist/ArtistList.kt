package com.jisunski.moviesmvvm.data.model.artist


import com.google.gson.annotations.SerializedName
import com.jisunski.moviesmvvm.data.model.artist.Artist

data class ArtistList(
    @SerializedName("results")
    val artists: List<Artist>
)