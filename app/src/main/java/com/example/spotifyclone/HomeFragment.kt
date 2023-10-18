package com.example.spotifyclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spotifyclone.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    var arr_recents = ArrayList<RecentsCardModel>()
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
        arr_recents.add(RecentsCardModel(R.drawable.img_dailymix2, "Arjit Singh Lofi Song❤️"))

        val adapter = RecyclerRecentsAdapter(requireContext(), arr_recents)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}