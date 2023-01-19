package com.example.navapp.navigation

import androidx.fragment.app.FragmentActivity
import com.example.edit.EditNavigation

class EditNavigator : EditNavigation {
    override fun closeSelf(activity: FragmentActivity) {
        activity.finish()
    }
}