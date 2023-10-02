package com.example.spotifyclone

import android.animation.ValueAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spotifyclone.databinding.FragmentPlaylistBinding
import com.example.spotifyclone.databinding.FragmentPremiumBinding

class PremiumFragment : Fragment() {
    private lateinit var binding: FragmentPremiumBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPremiumBinding.inflate(inflater, container, false)

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
            val targetScaleFactor = 1.0f - collapseRatio * 1f

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