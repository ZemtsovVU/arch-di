package com.example.navapp

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.example.edit.EditActivity

class AppNavigation : NavigationFacade {

    override fun openEditScreen(activity: FragmentActivity) {
        activity.startActivity(
            Intent(activity, EditActivity::class.java)
        )
    }

    override fun closeSelf(activity: FragmentActivity) {
        activity.finish()
    }
}