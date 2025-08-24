package com.example.skillswap

import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class LessonFragment : Fragment(R.layout.fragment_lesson) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val completedBtn = view.findViewById<MaterialButton>(R.id.completed_section_btn)
        val ongoingBtn = view.findViewById<MaterialButton>(R.id.ongoing_section_btn)
        val completedCard = view.findViewById<CardView>(R.id.completed_card)
        val ongoingCard = view.findViewById<CardView>(R.id.ongoing_card)

        completedCard.visibility = View.VISIBLE
        ongoingCard.visibility = View.GONE

        completedBtn.setOnClickListener {
            completedCard.visibility = View.VISIBLE
            ongoingCard.visibility = View.GONE
            completedBtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.green_2))
            ongoingBtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.gray_2))
        }

        ongoingBtn.setOnClickListener {
            completedCard.visibility = View.GONE
            ongoingCard.visibility = View.VISIBLE
            completedBtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.gray_2))
            ongoingBtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.green_2))
        }
    }
}