package com.example.demo

import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.example.home.HomeNavigation

class AppNavigation : HomeNavigation {

    override fun openEditScreen(activity: FragmentActivity) {
        Toast.makeText(
            activity,
            "It'a a Demo. Edit screen not available.",
            Toast.LENGTH_SHORT
        ).show()
    }
}