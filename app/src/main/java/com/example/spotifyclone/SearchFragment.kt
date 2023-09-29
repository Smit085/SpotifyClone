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
        binding = FragmentSearchBinding.inflate(inflater, container, false)

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


        val arrayList1 = ArrayList(arrCatg.subList(0, 3))
        val arrayList2 = ArrayList(arrCatg.subList(3, arrCatg.size))

        val adapter1 = RecyclerCategoryAdapter(requireContext(), arrayList1)
//        binding.recyclerView1.adapter = adapter1

        val adapter2 = RecyclerCategoryAdapter(requireContext(), arrayList2)
//        binding.recyclerView1.adapter = adapter2

//        binding.recyclerView1.layoutManager = GridLayoutManager(requireContext(),2)
//        binding.recyclerView1.adapter = adapter1
//
//        binding.recyclerView2.layoutManager = GridLayoutManager(requireContext(),2)
//        binding.recyclerView2.adapter = adapter2

        return binding.root
    }
}
