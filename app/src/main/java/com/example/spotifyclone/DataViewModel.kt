package com.example.spotifyclone

import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {
    var genres_dataFetched = false
    val arrCatg = ArrayList<CategoryCardModel>()
}
