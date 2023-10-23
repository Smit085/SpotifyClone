package com.example.spotifyclone

import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {
    var genres_dataFetched = false
    var dailymix_dataFetched = false
    var bestartists_dataFetched = false
    var indiasbest_dataFetched = false
    val arrCatg = ArrayList<CategoryCardModel>()
    var arr_recents = ArrayList<RecentsCardModel>()
    var arr_dailymix = ArrayList<DailymixCardModel>()
    var arr_bestartists = ArrayList<DailymixCardModel>()
    var arr_indiasbest = ArrayList<DailymixCardModel>()
    var arr_jbi = ArrayList<DailymixCardModel>()

    var arrsongdis = ArrayList<SongCardModel>()
}
