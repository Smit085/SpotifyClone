package com.example.spotifyclone

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val ihome = Intent(this, MainActivity::class.java)
            startActivity(ihome)
            finish() // Close the splash activity
        }, 1000)
    }
}