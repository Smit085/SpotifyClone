package com.example.spotifyclone

class CategoryCardModel {
    var img:Int = 0;
    var catName: String = ""

    constructor(img:Int,catName:String){
        this.catName = catName
        this.img = img
    }
}