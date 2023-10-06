package com.example.spotifyclone

import android.animation.ValueAnimator
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.spotifyclone.databinding.FragmentPlaylistBinding
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.math.abs


class PlaylistFragment : Fragment() {
    private lateinit var binding: FragmentPlaylistBinding
    var arrCatg = ArrayList<CategoryCardModel>()

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
                binding.scrollingImageView.scaleX = animatedValue
                binding.scrollingImageView.scaleY = animatedValue
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
                }
            } else {
                // The CollapsingToolbarLayout is not fully collapsed
                isCollapsed = false
            }

            // Update the last vertical offset
            lastVerticalOffset = verticalOffset
        }




















        return binding.root
    }
}