package com.example.chatcom.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.chatcom.mainScreens.Chats
import com.example.chatcom.mainScreens.Contacts
import com.example.chatcom.mainScreens.Settings

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                Chats()
            }
            1 -> {
                Contacts()
            }
            2 -> {
                Settings()
            }
            else -> {
                Fragment()
            }
        }
    }
}