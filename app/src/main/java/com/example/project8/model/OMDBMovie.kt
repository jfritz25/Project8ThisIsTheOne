package com.example.project8.model

import com.google.gson.annotations.SerializedName

data class OMDBMovie (
    @SerializedName("Genre") val genre: String,
    @SerializedName("imdbRating") val imdbRating: String,
    @SerializedName("Rated") val rating: String,
    @SerializedName("Year") val year: String,
    @SerializedName("Title") val title: String,
    @SerializedName("Runtime") val runtime: String,
    @SerializedName("Poster") val posterString: String,
    @SerializedName("imdbID") val imdbID: String,

    )