package com.example.spotifyclone

class DailymixCardModel {
    var id: String = ""
    var imgurl: String = "";
    var name: String = ""
    var description: String = ""

    constructor(id: String,imgurl: String,name: String,description: String){
        this.id = id
        this.description = description
        this.imgurl = imgurl
        this.name = name
    }
}