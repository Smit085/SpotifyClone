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


        arr_recents.add(RecentsCardModel(R.drawable.img_dailymix1, "Lofi Songs (Bollywood) \uD83D\uDE0C\uD83D\uDC9C"))
        arr_recents.add(RecentsCardModel(R.drawable.img_dailymix2, "2016-2018 Hindi Songs"))
        arr_recents.add(RecentsCardModel(R.drawable.img_dailymix2, "Hot Hits Hindi"))
        arr_recents.add(RecentsCardModel(R.drawable.img_dailymix2, "I-Pop Superhits"))
        arr_recents.add(RecentsCardModel(R.drawable.img_dailymix2, "This Is Pritam"))
        arr_recents.add(RecentsCardModel(R.drawable.img_dailymix2, "Arjit Singh Lofi Song❤️"))

        val adapter_dailymix = RecyclerDailymixAdapter(requireContext(), arr_dailymix)

        binding.recyclerViewDailymix.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewDailymix.adapter = adapter_dailymix















        return binding.root
    }
}