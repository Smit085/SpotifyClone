package com.example.spotifyclone

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spotifyclone.databinding.FragmentHomeBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HomeFragment : Fragment(){
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: DataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(DataViewModel::class.java)

        if (!viewModel.dailymix_dataFetched){
            fetchDataFromFirestore("dailymix")
        }
        if (!viewModel.bestartists_dataFetched){
            fetchDataFromFirestore("bestartists")
        }
        if (!viewModel.indiasbest_dataFetched){
            fetchDataFromFirestore("indiasbest")
        }
        else {
            setupRecyclerViews()
        }
        return binding.root
    }
    private fun fetchDataFromFirestore(collectionPath: String) {
        val db = FirebaseFirestore.getInstance()
        db.collection(collectionPath)
            .get()
            .addOnCompleteListener(OnCompleteListener<QuerySnapshot> { task ->
                if (task.isSuccessful) {
                    when(collectionPath){
                        "dailymix" -> {
                            for (document in task.result!!) {
                                val data = document.data
                                val id = data["id"] as String
                                val imgurl = data["imgurl"] as String
                                val name = data["name"] as String
                                val description = data["description"] as String
                                viewModel.arr_dailymix.add(DailymixCardModel(id,imgurl,name,description))
                            }
                            viewModel.dailymix_dataFetched = true
                            setupRecyclerViews()
                        }
                        "bestartists" -> {
                            for (document in task.result!!) {
                                val data = document.data
                                val id = data["id"] as String
                                val imgurl = data["imgurl"] as String
                                val name = data["name"] as String
                                val description = data["description"] as String
                                viewModel.arr_bestartists.add(DailymixCardModel(id,imgurl,name,description))
                            }
                            viewModel.bestartists_dataFetched = true
                            setupRecyclerViews()
                        }
                        "indiasbest" -> {
                            for (document in task.result!!) {
                                val data = document.data
                                val id = data["id"] as String
                                val imgurl = data["imgurl"] as String
                                val name = data["name"] as String
                                val description = data["description"] as String
                                viewModel.arr_indiasbest.add(DailymixCardModel(id,imgurl,name,description))
                            }
                            viewModel.indiasbest_dataFetched = true
                            setupRecyclerViews()
                        }
                    }
                } else {
                    Log.e("TAG", "Error fetching documents: ${task.exception}")
                }
            })
    }

    private fun setupRecyclerViews() {
        viewModel.arr_recents.clear()
        viewModel.arr_recents.add(RecentsCardModel(R.drawable.img_dailymix2, "Lofi Songs (Bollywood) \uD83D\uDE0C\uD83D\uDC9C"))
        viewModel.arr_recents.add(RecentsCardModel(R.drawable.img_likedsongs, "Liked Songs"))
        viewModel.arr_recents.add(RecentsCardModel(R.drawable.img_playlistbanner, "Latest Love Tunes"))
        viewModel.arr_recents.add(RecentsCardModel(R.drawable.img_dailymix2, "2016-2018 Hindi Songs"))
        viewModel.arr_recents.add(RecentsCardModel(R.drawable.img_dailymix2, "Hot Hits Hindi"))
        viewModel.arr_recents.add(RecentsCardModel(R.drawable.img_dailymix2, "I-Pop Superhits"))
        viewModel.arr_recents.add(RecentsCardModel(R.drawable.img_popularartist1, "This Is Pritam"))
        viewModel.arr_recents.add(RecentsCardModel(R.drawable.img_dailymix2, "Arjit Singh Lofi Song❤️"))

        val adapter_recents = RecyclerRecentsAdapter(requireContext(), viewModel.arr_recents)
        binding.recyclerViewRecents.layoutManager = GridLayoutManager(requireContext(),2)
        binding.recyclerViewRecents.adapter = adapter_recents

        val adapter_dailymix = RecyclerDailymixAdapter(requireContext(), viewModel.arr_dailymix)
        binding.recyclerViewDailymix.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewDailymix.adapter = adapter_dailymix

        val adapter_bestartists = RecyclerDailymixAdapter(requireContext(), viewModel.arr_bestartists)
        binding.recyclerViewBestartists.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewBestartists.adapter = adapter_bestartists

        val adapter_indiasbest = RecyclerDailymixAdapter(requireContext(), viewModel.arr_indiasbest)
        binding.recyclerViewIndiasbest.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewIndiasbest.adapter = adapter_indiasbest


        viewModel.arr_jbi.clear()
        viewModel.arr_jbi.add(DailymixCardModel("","","", "Lofi Songs (Bollywood) \uD83D\uDE0C\uD83D\uDC9C"))
        viewModel.arr_jbi.add(DailymixCardModel("","","", "Liked Songs"))
        viewModel.arr_jbi.add(DailymixCardModel("","","", "Latest Love Tunes"))
        viewModel.arr_jbi.add(DailymixCardModel("","","", "2016-2018 Hindi Songs"))
        viewModel.arr_jbi.add(DailymixCardModel("","","", "Hot Hits Hindi"))
        viewModel.arr_jbi.add(DailymixCardModel("","","", "I-Pop Superhits"))
        viewModel.arr_jbi.add(DailymixCardModel("","","", "This Is Pritam"))
        viewModel.arr_jbi.add(DailymixCardModel("","","", "Arjit Singh Lofi Song❤️"))

        val adapter_jbi = RecyclerDailymixAdapter(requireContext(), viewModel.arr_jbi)
        binding.recyclerViewJbi.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewJbi.adapter = adapter_jbi
    }
}