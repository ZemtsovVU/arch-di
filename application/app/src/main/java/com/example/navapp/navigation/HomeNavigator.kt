package com.example.navapp.navigation

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.example.edit.EditActivity
import com.example.home.HomeNavigation

class HomeNavigator : HomeNavigation {
    override fun openEditScreen(activity: FragmentActivity) {
        activity.startActivity(
            Intent(activity, EditActivity::class.java)
        )
    }
}