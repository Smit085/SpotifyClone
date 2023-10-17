package com.example.spotifyclone

class SongCardModel {
    var songImage:Int = 0;
    var songName: String = ""
    var singerName: String = ""
    var lyrics: Boolean = false

    constructor(img: Int,songName: String, singerName: String, lyrics: Boolean){
        this.songImage = img
        this.songName = songName
        this.singerName = singerName
        this.lyrics = lyrics
    }
}