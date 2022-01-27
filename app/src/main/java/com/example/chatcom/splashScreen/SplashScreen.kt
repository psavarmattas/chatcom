package com.example.chatcom.splashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.ImageView
import com.example.chatcom.MainActivity
import com.example.chatcom.R

class SplashScreen : AppCompatActivity() {
    private lateinit var imageSplash: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        imageSplash = findViewById(R.id.SplashScreenImage)
        Handler().postDelayed(
            {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            },3000)
    }
}