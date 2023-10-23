package com.example.spotifyclone

class SongCardModel {
    var imgurl:String = "";
    var name: String = ""
    var singers: String = ""
    var duration: String = ""
    var lyrics: Boolean = false

    constructor(imgurl: String,name: String, singers: String,duration: String, lyrics: Boolean){
        this.imgurl = imgurl
        this.name = name
        this.singers = singers
        this.duration = duration
        this.lyrics = lyrics
    }
}