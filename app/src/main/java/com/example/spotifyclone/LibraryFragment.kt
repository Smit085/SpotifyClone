package com.example.spotifyclone

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LibraryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val  retofitData = retrofitBuilder.getData("eminem")

        retofitData.enqueue(object : Callback<ApiData?> {
            override fun onResponse(call: Call<ApiData?>, response: Response<ApiData?>) {
                val dataList = response.body()?.total
                Log.i("Onresponse",response.body()?.total.toString())
            }

            override fun onFailure(call: Call<ApiData?>, t: Throwable) {
                Log.i("onFailure","NO"+t.message)
            }
        })












        return inflater.inflate(R.layout.fragment_library, container, false)
    }
}