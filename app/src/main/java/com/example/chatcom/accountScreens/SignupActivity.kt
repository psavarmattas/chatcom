package com.example.chatcom.accountScreens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.chatcom.MainActivity
import com.example.chatcom.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        auth = FirebaseAuth.getInstance()

        btnSign_up.setOnClickListener {
            signupUser()
        }

    }
    fun signupUser(){
        if (username.toString().isEmpty()){
            username.error = "Please enter email"
            username.requestFocus()
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(username.text.toString()).matches()){
            username.error = "Please enter valid Email"
            username.requestFocus()
            return
        }
        if (password.text.toString().isEmpty()){
            password.error = "Please enter Password"
            password.requestFocus()
            return

        }
        auth.createUserWithEmailAndPassword(username.text.toString(), password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(baseContext,"Yay! You are registered!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(baseContext, "Sign Up Failed",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}