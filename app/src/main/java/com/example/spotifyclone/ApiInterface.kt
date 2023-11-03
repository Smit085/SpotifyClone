package com.example.spotifyclone

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {

    @Headers("X-RapidAPI-Key: fdcf43a8a9mshcdf61e7217511ddp163043jsndf535f6e4efe",
            "X-RapidAPI-Host: spotify23.p.rapidapi.com")

    @GET("playlist_tracks/")
    fun getData(@Query("id") query: String,@Query("offset") offset: Int,@Query("limit") limit: Int): Call<PlaylistInfo>

}