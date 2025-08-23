package com.example.skillswap

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class OnboardingActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var nextButton: MaterialButton
    private lateinit var skipButton: MaterialButton
    private lateinit var getStartedButton: MaterialButton
    private lateinit var dotsIndicator: WormDotsIndicator
    private lateinit var adapter: OnboardingAdapter

    private val layouts = listOf(
        R.layout.layout_onboarding_screen_1,
        R.layout.layout_onboarding_screen_2,
        R.layout.layout_onboarding_screen_3
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboarding)

        viewPager = findViewById(R.id.view_pager)
        nextButton = findViewById(R.id.btn_next)
        skipButton = findViewById(R.id.btn_skip)
        getStartedButton = findViewById(R.id.btn_get_started)
        dotsIndicator = findViewById(R.id.dots_indicator)

        adapter = OnboardingAdapter(layouts)
        viewPager.adapter = adapter
        dotsIndicator.attachTo(viewPager)

        updateButtons(viewPager.currentItem)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                updateButtons(position)
            }
        })

        nextButton.setOnClickListener {
            if (viewPager.currentItem + 1 < layouts.size) {
                viewPager.currentItem += 1
            }
        }

        skipButton.setOnClickListener {
            finishOnboarding()
        }

        getStartedButton.setOnClickListener {
            finishOnboarding()
        }
    }

    private fun updateButtons(position: Int) {
        if (position == layouts.lastIndex) {
            skipButton.visibility = MaterialButton.GONE
            nextButton.visibility = MaterialButton.GONE
            dotsIndicator.visibility = View.GONE
            getStartedButton.visibility = MaterialButton.VISIBLE
        } else {
            skipButton.visibility = MaterialButton.VISIBLE
            nextButton.visibility = MaterialButton.VISIBLE
            getStartedButton.visibility = MaterialButton.GONE
        }
    }

    private fun finishOnboarding() {
        getSharedPreferences("prefs", MODE_PRIVATE)
            .edit { putBoolean("onboarding_done", true) }
        startActivity(Intent(this, AuthScreenActivity::class.java))
        finish()
    }
}
