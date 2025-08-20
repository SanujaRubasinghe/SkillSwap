package com.example.skillswap

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: MainAdapter
    private lateinit var navHomeBtn: MaterialButton
    private lateinit var navLessonBtn: MaterialButton
    private lateinit var navGoalsBtn: MaterialButton
    private lateinit var navUserProfileBtn: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.main_view_pager)
        navHomeBtn = findViewById(R.id.nav_home_btn)
        navGoalsBtn = findViewById(R.id.nav_goals_btn)
        navLessonBtn = findViewById(R.id.nav_lesson_btn)
        navUserProfileBtn = findViewById(R.id.nav_user_profile_btn)

        val layouts = listOf(
            R.layout.activity_home,
            R.layout.layout_goals_screen
        )

        adapter = MainAdapter(layouts)
        viewPager.adapter = adapter

        navHomeBtn.setOnClickListener {
            viewPager.currentItem = 0
        }

        navGoalsBtn.setOnClickListener {
            viewPager.currentItem = 1
        }
    }
}