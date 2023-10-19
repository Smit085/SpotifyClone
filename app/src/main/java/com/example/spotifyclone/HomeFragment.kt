package com.example.spotifyclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spotifyclone.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    var arr_recents = ArrayList<RecentsCardModel>()
    var arr_dailymix = ArrayList<DailymixCardModel>()
    var arr_bestartists = ArrayList<DailymixCardModel>()
    var arr_indiasbest = ArrayList<DailymixCardModel>()
    var arr_jbi = ArrayList<DailymixCardModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        arr_recents.add(RecentsCardModel(R.drawable.img_dailymix2, "Lofi Songs (Bollywood) \uD83D\uDE0C\uD83D\uDC9C"))
        arr_recents.add(RecentsCardModel(R.drawable.img_likedsongs, "Liked Songs"))
        arr_recents.add(RecentsCardModel(R.drawable.img_playlistbanner, "Latest Love Tunes"))
        arr_recents.add(RecentsCardModel(R.drawable.img_dailymix2, "2016-2018 Hindi Songs"))
        arr_recents.add(RecentsCardModel(R.drawable.img_dailymix2, "Hot Hits Hindi"))
        arr_recents.add(RecentsCardModel(R.drawable.img_dailymix2, "I-Pop Superhits"))
        arr_recents.add(RecentsCardModel(R.drawable.img_popularartist1, "This Is Pritam"))
        arr_recents.add(RecentsCardModel(R.drawable.img_dailymix2, "Arjit Singh Lofi Song❤️"))

        val adapter_recents = RecyclerRecentsAdapter(requireContext(), arr_recents)

        binding.recyclerViewRecents.layoutManager = GridLayoutManager(requireContext(),2)
        binding.recyclerViewRecents.adapter = adapter_recents


        arr_dailymix.add(DailymixCardModel(R.drawable.img_dailymix1, "Pritam, Arijit Singh, Imdad Hussain and more"))
        arr_dailymix.add(DailymixCardModel(R.drawable.img_dailymix1, "Pritam, Arijit Singh, Imdad Hussain and more"))
        arr_dailymix.add(DailymixCardModel(R.drawable.img_dailymix1, "Pritam, Arijit Singh, Imdad Hussain and more"))
        arr_dailymix.add(DailymixCardModel(R.drawable.img_dailymix1, "Pritam, Arijit Singh, Imdad Hussain and more"))
        arr_dailymix.add(DailymixCardModel(R.drawable.img_dailymix1, "Pritam, Arijit Singh, Imdad Hussain and more"))
        arr_dailymix.add(DailymixCardModel(R.drawable.img_dailymix1, "Pritam, Arijit Singh, Imdad Hussain and more"))

        val adapter_dailymix = RecyclerDailymixAdapter(requireContext(), arr_dailymix)
        binding.recyclerViewDailymix.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewDailymix.adapter = adapter_dailymix


        arr_bestartists.add(DailymixCardModel(R.drawable.img_artists1, "This is Pritam. The essential tracks, all in one playlist."))
        arr_bestartists.add(DailymixCardModel(R.drawable.img_artists1, "This is Pritam. The essential tracks, all in one playlist."))
        arr_bestartists.add(DailymixCardModel(R.drawable.img_artists1, "This is Pritam. The essential tracks, all in one playlist."))
        arr_bestartists.add(DailymixCardModel(R.drawable.img_artists1, "This is Pritam. The essential tracks, all in one playlist."))
        arr_bestartists.add(DailymixCardModel(R.drawable.img_artists1, "This is Pritam. The essential tracks, all in one playlist."))
        arr_bestartists.add(DailymixCardModel(R.drawable.img_artists1, "This is Pritam. The essential tracks, all in one playlist."))

        val adapter_bestartists = RecyclerDailymixAdapter(requireContext(), arr_bestartists)
        binding.recyclerViewBestartists.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewBestartists.adapter = adapter_bestartists

        arr_indiasbest.add(DailymixCardModel(R.drawable.img_indiasbest, "B bole toh biggest blockbusters, right here! Koi Shaq? \uD83D\uDE0E Cover - Jawan\n"))
        arr_indiasbest.add(DailymixCardModel(R.drawable.img_indiasbest, "B bole toh biggest blockbusters, right here! Koi Shaq? \uD83D\uDE0E Cover - Jawan\n"))
        arr_indiasbest.add(DailymixCardModel(R.drawable.img_indiasbest, "B bole toh biggest blockbusters, right here! Koi Shaq? \uD83D\uDE0E Cover - Jawan\n"))
        arr_indiasbest.add(DailymixCardModel(R.drawable.img_indiasbest, "B bole toh biggest blockbusters, right here! Koi Shaq? \uD83D\uDE0E Cover - Jawan\n"))
        arr_indiasbest.add(DailymixCardModel(R.drawable.img_indiasbest, "B bole toh biggest blockbusters, right here! Koi Shaq? \uD83D\uDE0E Cover - Jawan\n"))
        arr_indiasbest.add(DailymixCardModel(R.drawable.img_indiasbest, "B bole toh biggest blockbusters, right here! Koi Shaq? \uD83D\uDE0E Cover - Jawan\n"))

        val adapter_indiasbest = RecyclerDailymixAdapter(requireContext(), arr_indiasbest)
        binding.recyclerViewIndiasbest.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewIndiasbest.adapter = adapter_indiasbest


        arr_jbi.add(DailymixCardModel(R.drawable.img_dailymix2, "Lofi Songs (Bollywood) \uD83D\uDE0C\uD83D\uDC9C"))
        arr_jbi.add(DailymixCardModel(R.drawable.img_likedsongs, "Liked Songs"))
        arr_jbi.add(DailymixCardModel(R.drawable.img_playlistbanner, "Latest Love Tunes"))
        arr_jbi.add(DailymixCardModel(R.drawable.img_dailymix2, "2016-2018 Hindi Songs"))
        arr_jbi.add(DailymixCardModel(R.drawable.img_dailymix2, "Hot Hits Hindi"))
        arr_jbi.add(DailymixCardModel(R.drawable.img_dailymix2, "I-Pop Superhits"))
        arr_jbi.add(DailymixCardModel(R.drawable.img_popularartist1, "This Is Pritam"))
        arr_jbi.add(DailymixCardModel(R.drawable.img_dailymix2, "Arjit Singh Lofi Song❤️"))

        val adapter_jbi = RecyclerDailymixAdapter(requireContext(), arr_jbi)
        binding.recyclerViewJbi.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewJbi.adapter = adapter_jbi













        return binding.root
    }
}