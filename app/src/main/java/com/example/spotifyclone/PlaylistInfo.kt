package com.example.spotifyclone

data class PlaylistInfo(
    val name: String,
    val description: String,
    val images: List<PlaylistImage>
)

data class PlaylistImage(
    val url: String,
    val width: Int,
    val height: Int
)
