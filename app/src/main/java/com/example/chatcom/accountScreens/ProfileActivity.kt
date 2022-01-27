package com.example.chatcom.accountScreens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.chatcom.MainActivity
import com.example.chatcom.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        auth = FirebaseAuth.getInstance()

        val user = FirebaseAuth.getInstance().currentUser

        user?.let {
            val email = user.email
            welcome.setText("Welcome "+email+"!")
        }

        btnSign_out.setOnClickListener {view->
            Toast.makeText(baseContext,"Logging Out!", Toast.LENGTH_SHORT).show()
            signOut()
        }
    }

    private fun signOut() {
        FirebaseAuth.getInstance().signOut()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}