package com.example.spotifyclone

import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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


class PlaylistFragment : Fragment(), RecyclerSongAdapter.ItemClickListener {
    private lateinit var binding: FragmentPlaylistBinding
    private lateinit var viewModel: DataViewModel
    var fav_state = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentPlaylistBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(DataViewModel::class.java)

        binding.txtDescription.text = arguments?.getString("description")
        Picasso.get().load(arguments?.getString("imgurl")).into(binding.imgPlaylist)
        arguments?.getString("id")?.let { fetchDataFromApi(it) }


        var isCollapsed = false
        var scaleFactor = 1.0f
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

        binding.btnFav.setOnClickListener {
            if (fav_state == 0) {
                binding.btnFav.setImageResource(R.drawable.icon_favourite_red)
                fav_state = 1
            } else {
                binding.btnFav.setImageResource(R.drawable.icon_favourite)
                fav_state = 0
            }
        }

        return binding.root
    }

    private fun fetchDataFromApi(id: String) {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://spotify23.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retofitData = retrofitBuilder.getData(id, 0, 15)

        retofitData.enqueue(object : Callback<PlaylistInfo?> {
            override fun onResponse(call: Call<PlaylistInfo?>, response: Response<PlaylistInfo?>) {
                val dataList = response.body()
                viewModel.arrsongdis.clear()
                dataList?.items?.let { items ->
                    for (item in items) {
                        val min = String.format("%02d", (item.track.duration_ms / 1000 / 60))
                        val sec = String.format("%02d", (item.track.duration_ms / 1000 % 60))
                        viewModel.arrsongdis.add(
                            SongCardModel(
                                item.track.album.images[0].url,
                                item.track.name,
                                item.track.artists.joinToString { it.name },
                                "$min:$sec",
                                item.track.preview_url,
                                false
                            )
                        )
                    }
                    if (viewModel.arrsongdis.isNotEmpty()) {
                        setupRecyclerViews()
                    }
                }
                Log.i("Onresponse", "Response: ${response.raw()}, Body: ${response.body()}")
            }

            override fun onFailure(call: Call<PlaylistInfo?>, t: Throwable) {
                Log.i("onFailure", "ERROR: " + t.message)
            }
        })
    }

    private fun setupRecyclerViews() {
        val adapter = RecyclerSongAdapter(requireContext(), viewModel.arrsongdis)
        adapter.itemClickListener = this
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }


    override fun onItemClicked(songIndex: Int) {
//        val musicPlayer = MusicPlayer()
//        musicPlayer.updateplayer(viewModel.arrsongdis[songIndex].songurl,viewModel.arrsongdis[songIndex].imgurl, viewModel.arrsongdis[songIndex].name, viewModel.arrsongdis[songIndex].singers)

//        val bundle = Bundle()
//        bundle.putString("songname", viewModel.arrsongdis[songIndex].name)
//        bundle.putBoolean("data_transferred", true)
//        val bottomSheetDialog = MusicPlayer()
//        bottomSheetDialog.arguments = bundle

        MusicPlayer.DataRepository.songName = viewModel.arrsongdis[songIndex].name
        MusicPlayer.DataRepository.songurl = viewModel.arrsongdis[songIndex].songurl
        MusicPlayer.DataRepository.imgurl = viewModel.arrsongdis[songIndex].imgurl
        MusicPlayer.DataRepository.singers = viewModel.arrsongdis[songIndex].singers
        (requireActivity() as MainActivity).updateTextViewText(songIndex)
    }
}