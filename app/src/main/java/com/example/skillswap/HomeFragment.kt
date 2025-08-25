package com.example.skillswap

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val notificationBtn = view.findViewById<FloatingActionButton>(R.id.notification_btn)
        val searchBtn = view.findViewById<FloatingActionButton>(R.id.search_btn)
        val userProfileBtn = view.findViewById<MaterialButton>(R.id.user_profile_btn)

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

    }
}
