package com.example.skillswap

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class NotificationActivity : AppCompatActivity() {
    private lateinit var backBtn: MaterialButton
    private lateinit var clearBtn: MaterialButton
    private lateinit var noNotificationsText: TextView
    private lateinit var notificationCard: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_notification)

        backBtn = findViewById<MaterialButton>(R.id.back_btn)
        clearBtn = findViewById<MaterialButton>(R.id.clear_button)
        noNotificationsText = findViewById(R.id.no_notifications_text)
        notificationCard = findViewById(R.id.notification_card)

        noNotificationsText.visibility = View.GONE
        notificationCard.visibility = View.VISIBLE
        clearBtn.visibility = View.VISIBLE

        clearBtn.setOnClickListener {
            notificationCard.visibility = View.GONE
            noNotificationsText.visibility = View.VISIBLE
            clearBtn.visibility = View.GONE
        }

        backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(
            R.anim.slide_in_left,
            R.anim.slide_out_right
        )
    }
}