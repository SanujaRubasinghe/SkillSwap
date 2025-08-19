package com.example.skillswap

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class AuthScreenActivity : AppCompatActivity() {
    private lateinit var loginBtn: Button
    private lateinit var registerBtn: MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_auth_screen)

        loginBtn = findViewById(R.id.login_btn)
        registerBtn = findViewById(R.id.register_btn)

        loginBtn.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        registerBtn.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}