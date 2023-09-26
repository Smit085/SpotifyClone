package com.example.spotifyclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.spotifyclone.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    var arrCatg = ArrayList<CategoryCardModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img,"Live Events"))


        val adapter = RecyclerCategoryAdapter(requireContext(), arrCatg)
        binding.recyclerView.adapter = adapter

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
        binding.recyclerView.adapter = adapter


        return binding.root
    }
}
