package com.example.spotifyclone

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {

    @Headers("X-RapidAPI-Key: 702fbf3640mshdce5f4f0c56be7fp1b5c7ejsn0de525605c39",
            "X-RapidAPI-Host: spotify23.p.rapidapi.com")

    @GET("playlist_tracks/")
    fun getData(@Query("id") query: String,@Query("offset") offset: Int,@Query("limit") limit: Int): Call<PlaylistInfo>

}