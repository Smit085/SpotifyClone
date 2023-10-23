package com.example.spotifyclone

import android.animation.ValueAnimator
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spotifyclone.databinding.FragmentPlaylistBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PlaylistFragment : Fragment() {
    private lateinit var binding: FragmentPlaylistBinding
    private lateinit var viewModel: DataViewModel


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentPlaylistBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(DataViewModel::class.java)

//        if(!viewModel.arrsongdis_dataFetched){
//            setupRecyclerViews()
//        }

        binding.txtDescription.text = arguments?.getString("description")
        Picasso.get().load(arguments?.getString("imgurl")).into(binding.imgPlaylist)
        arguments?.getString("id")?.let { fetchDataFromApi(it) }


        var isCollapsed = false
        var scaleFactor = 1.0f // Initialize the scale factor
        var lastVerticalOffset = 0

        binding.appBarLayout.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            // Calculate the total scroll range of the CollapsingToolbarLayout
            val totalScrollRange = appBarLayout.totalScrollRange

            // Calculate the percentage of collapse (0 to 1)
            val collapseRatio = -verticalOffset.toFloat() / totalScrollRange.toFloat()

            // Calculate the target scale factor based on the collapse ratio
            // Adjust the scaleFactor range as needed
            val targetScaleFactor = 1.0f - collapseRatio * 0.5f

            // Use ValueAnimator to smoothly interpolate the scale factor
            val animator = ValueAnimator.ofFloat(scaleFactor, targetScaleFactor)
            animator.duration = 100 // Adjust the duration as needed
            animator.addUpdateListener { animation ->
                val animatedValue = animation.animatedValue as Float

                // Apply the interpolated scale factor to the ImageView
                binding.imgPlaylist.scaleX = animatedValue
                binding.imgPlaylist.scaleY = animatedValue
            }
            animator.start()

            // Update the scale factor
            scaleFactor = targetScaleFactor

            // Check if the CollapsingToolbarLayout is fully collapsed
            if (verticalOffset == -totalScrollRange) {
                if (!isCollapsed) {
                    // The CollapsingToolbarLayout is now fully collapsed
                    // Perform actions or call methods here
                    isCollapsed = true
                    binding.txtTitle.visibility = View.VISIBLE
                }
            } else {
                // The CollapsingToolbarLayout is not fully collapsed
                isCollapsed = false
                binding.txtTitle.visibility = View.GONE
            }

            // Update the last vertical offset
            lastVerticalOffset = verticalOffset

        }

        return binding.root
    }

    private fun fetchDataFromApi(id: String){
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://spotify23.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val  retofitData = retrofitBuilder.getData(id,0,15)

        retofitData.enqueue(object : Callback<PlaylistInfo?> {
            override fun onResponse(call: Call<PlaylistInfo?>, response: Response<PlaylistInfo?>) {
                val dataList = response.body()
                dataList?.items?.let { items ->
                    for (item in items) {
                        val min = String.format("%02d", (item.track.duration_ms / 1000 / 60))
                        val sec = String.format("%02d", (item.track.duration_ms / 1000 % 60))
                        viewModel.arrsongdis.add(SongCardModel(
                            item.track.album.images[2].url,
                            item.track.name,
                            item.track.artists.joinToString { it.name } + "." ,
                            "$min:$sec",
                            false
                        ))
                    }
                    if (viewModel.arrsongdis.isNotEmpty()) {
                        setupRecyclerViews()
                    }
                }
                Log.i("Onresponse", "Response: ${response.raw()}, Body: ${response.body()}")
            }
            override fun onFailure(call: Call<PlaylistInfo?>, t: Throwable) {
                Log.i("onFailure","ERROR: "+t.message)
            }
        })
    }


    private fun setupRecyclerViews() {
        val adapter = RecyclerSongAdapter(requireContext(), viewModel.arrsongdis)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }
}