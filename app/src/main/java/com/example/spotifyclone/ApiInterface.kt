package com.example.spotifyclone

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {

    @Headers("X-RapidAPI-Key: d8371881dfmshf3baf03e7dfa1a4p10c85djsn956d3724b081",
            "X-RapidAPI-Host: spotify23.p.rapidapi.com")

    @GET("playlist/")
    fun getData(@Query("id") query: String): Call<PlaylistInfo>

}