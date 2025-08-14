package com.example.skillswap

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        findViewById<TextView>(R.id.main_title).apply {
            visibility = View.VISIBLE
            startAnimation(fadeIn)

            fadeIn.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(a: Animation) {}
                override fun onAnimationEnd(a: Animation) {alpha = 1f}
                override fun onAnimationRepeat(a: Animation) {}
            })
        }

        Handler(Looper.getMainLooper()).postDelayed({
            val pref: SharedPreferences = getSharedPreferences("SkillSwapPrefs", MODE_PRIVATE)
            val onboardingCompleted = pref.getBoolean("onboardingCompleted", false)

            if (onboardingCompleted) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                startActivity(Intent(this, OnboardingActivity::class.java))
            }
            finish()
        }, 2000)

    }
}