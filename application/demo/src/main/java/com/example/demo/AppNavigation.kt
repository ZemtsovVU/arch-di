package com.example.demo

import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.example.navigation.NavigationFacade

class AppNavigation : NavigationFacade {

    override fun openEditScreen(activity: FragmentActivity) {
        Toast.makeText(
            activity,
            "It'a a Demo. Edit screen not available.",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun closeSelf(activity: FragmentActivity) = Unit
}