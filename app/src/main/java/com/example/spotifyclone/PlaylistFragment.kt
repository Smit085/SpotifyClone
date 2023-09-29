package com.example.spotifyclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.spotifyclone.databinding.FragmentPlaylistBinding

class PlaylistFragment : Fragment() {
    private lateinit var binding: FragmentPlaylistBinding
    var arrCatg = ArrayList<CategoryCardModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlaylistBinding.inflate(inflater, container, false)

        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events\nnear you"))


        val arrayList = ArrayList(arrCatg.subList(3, arrCatg.size))

        val adapter = RecyclerCategoryAdapter(requireContext(), arrayList)


        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
        binding.recyclerView.adapter = adapter

        return binding.root
    }
}