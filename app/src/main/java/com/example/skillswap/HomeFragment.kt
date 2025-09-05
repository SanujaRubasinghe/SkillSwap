package com.example.skillswap

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val images = listOf(
            R.drawable.pasta_mastery,
            R.drawable.guitar_mastery
        )

        val notificationBtn = view.findViewById<FloatingActionButton>(R.id.notification_btn)
        val searchBtn = view.findViewById<FloatingActionButton>(R.id.search_btn)
        val cardContainer = view.findViewById<LinearLayout>(R.id.lessonCardContainer)

        notificationBtn.setOnClickListener {
            val intent = Intent(requireContext(), NotificationActivity::class.java)
            startActivity(intent)
            requireActivity().overridePendingTransition(
                R.anim.slide_in_right,
                R.anim.slide_out_left
            )
        }

        searchBtn.setOnClickListener {
            val intent = Intent(requireContext(), SearchActivity::class.java)
            startActivity(intent)
            requireActivity().overridePendingTransition(
                R.anim.slide_in_bottom,
                R.anim.slide_out_top
            )
        }

        for (image in images) {
            val cardView = CardView(requireContext()).apply {
                layoutParams = LinearLayout.LayoutParams(
                    200.dpToPx(),
                    250.dpToPx()
                ).apply {
                    setMargins(10.dpToPx(), 0, 10.dpToPx(), 0)
                }
                radius = 20f
            }

            val imageView = ImageView(requireContext()).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                scaleType = ImageView.ScaleType.CENTER_CROP
                setImageResource(image)
            }

            cardView.addView(imageView)
            cardContainer.addView(cardView)
        }

    }

    fun Int.dpToPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()
}
