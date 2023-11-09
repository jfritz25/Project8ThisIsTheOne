package com.example.project8


import com.example.project8.model.OMDBMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "4d23ddf4"

public interface OMDBapi {
    /**
     * Interface defining the methods for making requests to the OMDB (Open Movie Database) API.
     * The base URL and API key are constants defined in this interface.
     */
    @GET("?apikey=$API_KEY")
    fun search(@Query("t") title: String): Call<OMDBMovie>
}
