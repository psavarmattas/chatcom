package com.example.chatcom.mainScreens

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.chatcom.R
import com.example.chatcom.accountScreens.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_settings.*



class Settings : Fragment(R.layout.fragment_settings) {

    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        val user = FirebaseAuth.getInstance().currentUser

        user?.let {
            val email = user.email
//            FirebaseAuth.getInstance().currentUser?.displayName
            profilePageText.setText("Id: " + email + "!")
        }

        checkProfile.setOnClickListener {
            //FirebaseAuth.getInstance().signOut()
            Toast.makeText(activity, "Checking Profile Status", Toast.LENGTH_LONG).show()
            val intent = Intent(activity, LoginActivity::class.java)
            activity?.startActivity(intent)
        }
    }
}