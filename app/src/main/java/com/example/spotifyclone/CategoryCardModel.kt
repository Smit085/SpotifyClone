package com.example.spotifyclone

class CategoryCardModel {
    var imgurl: String = "";
    var name: String = ""
    var bg_color: String = ""

    constructor(imgurl:String,name:String,bg_color: String){
        this.name = name
        this.imgurl = imgurl
        this.bg_color = bg_color
    }
}