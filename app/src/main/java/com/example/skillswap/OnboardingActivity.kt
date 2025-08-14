package com.example.skillswap

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton
import androidx.core.content.edit
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class OnboardingActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var nextButton: Button
    private lateinit var tabLayout: TabLayout
    private lateinit var adapter: OnboardingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboarding)

        viewPager = findViewById(R.id.view_pager)
        nextButton = findViewById(R.id.btn_next)
        tabLayout = findViewById(R.id.tab_layout)

        val layouts = listOf(
            R.layout.layout_onboarding_screen_1,
            R.layout.layout_onboarding_screen_2,
            R.layout.layout_onboarding_screen_3
        )

        adapter = OnboardingAdapter(layouts)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) {_, _ ->}.attach()

        nextButton.setOnClickListener {
            if (viewPager.currentItem + 1 < layouts.size) {
                viewPager.currentItem += 1
            } else {
                getSharedPreferences("prefs", MODE_PRIVATE)
                    .edit {
                        putBoolean("onboarding_done", true)
                    }

                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}