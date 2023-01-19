package com.example.demo.navigation

import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.example.home.HomeNavigation

class HomeNavigator : HomeNavigation {
    override fun openEditScreen(activity: FragmentActivity) {
        Toast.makeText(
            activity,
            "It'a a Demo. Edit screen not available.",
            Toast.LENGTH_SHORT
        ).show()
    }
}