package com.example.app.navigation

import androidx.fragment.app.FragmentActivity
import com.example.edit.ui.EditNavigation

class EditNavigator : EditNavigation {
    override fun closeSelf(activity: FragmentActivity) {
        activity.finish()
    }
}