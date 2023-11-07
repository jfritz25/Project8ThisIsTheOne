package com.example.project8


import com.example.project8.model.OMDBMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "4d23ddf4"

public interface OMDBapi {
    @GET("?apikey=$API_KEY")
    fun search(@Query("t") title: String): Call<OMDBMovie>
}
