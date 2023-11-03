package com.example.project8


import com.example.project8.model.OMDBMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


public interface OMDBapi {
    @GET("?t={title}")
    fun search(@Path("title") title: String?): Call<OMDBMovie>?
}
