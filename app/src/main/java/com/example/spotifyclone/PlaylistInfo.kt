package com.example.spotifyclone

data class PlaylistInfo(
    val items: List<TrackItem>
)

data class TrackItem(
    val track: Track,
)

data class Track(
    val album: Album,
    val artists: List<Artist>,
    val duration_ms: Long,
    val name: String,
    val preview_url: String
)

data class Album(
    val images: List<Image>
)

data class Artist(
    val name: String
)

data class Image(
    val height: Int,
    val url: String,
    val width: Int
)
