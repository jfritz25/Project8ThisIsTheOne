package com.example.project8

import com.example.project8.model.OMDBMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

public interface OMDBapi {

    @GET("/")
    fun search(
        @Query("t") searchTerm: String) : Call<OMDBMovie>

}