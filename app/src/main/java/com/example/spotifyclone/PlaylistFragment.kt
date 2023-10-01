package com.example.spotifyclone

import android.animation.ValueAnimator
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Animation.RELATIVE_TO_SELF
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.spotifyclone.databinding.FragmentPlaylistBinding


class PlaylistFragment : Fragment() {
    private lateinit var binding: FragmentPlaylistBinding
    var arrCatg = ArrayList<CategoryCardModel>()
    private var lastScrollY = 0
    private var scaleFactor = 1.0f

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPlaylistBinding.inflate(inflater, container, false)

        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))
        arrCatg.add(CategoryCardModel(R.drawable.live_events_category_img, "Live Events\nnear you"))


        val arrayList1 = ArrayList(arrCatg.subList(0, 3))
        val arrayList2 = ArrayList(arrCatg.subList(3, arrCatg.size))

        val adapter1 = RecyclerCategoryAdapter(requireContext(), arrayList1)
//        binding.recyclerView1.adapter = adapter1

        val adapter2 = RecyclerCategoryAdapter(requireContext(), arrayList2)
//        binding.recyclerView1.adapter = adapter2

        binding.recyclerView1.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView1.adapter = adapter1

        binding.recyclerView2.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView2.adapter = adapter2

        binding.recyclerView1.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView1.adapter = adapter1

        binding.recyclerView2.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView2.adapter = adapter2


        binding.nestedScrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            val deltaY = scrollY - lastScrollY

            // Increase the scale factor with each scroll position change
            scaleFactor += deltaY * 0.002f

            // Limit the scale factor to a reasonable range
            scaleFactor = scaleFactor.coerceIn(1.0f, 2.0f)

            // Apply the scale factor to the ImageView
            val scaleAnimation = ScaleAnimation(
                0.5f, scaleFactor, // Start and end scale X
                0.5f, scaleFactor, // Start and end scale Y
                RELATIVE_TO_SELF, 0.5f, // Pivot point X
                RELATIVE_TO_SELF, 0.5f // Pivot point Y
            )
            scaleAnimation.duration = 500 // No animation duration
            scaleAnimation.fillAfter = true

            // Start the animation
            binding.scrollingImageView.startAnimation(scaleAnimation)

            lastScrollY = scrollY
        })
        return binding.root
    }
}