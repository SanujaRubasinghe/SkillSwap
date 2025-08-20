package com.example.skillswap

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    private lateinit var backBtn: Button
    private lateinit var loginConfirmBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        backBtn = findViewById(R.id.back_btn)
        loginConfirmBtn = findViewById(R.id.login_confirm_btn)

        backBtn.setOnClickListener {
            startActivity(Intent(this, AuthScreenActivity::class.java))
            finish()
        }

        loginConfirmBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}