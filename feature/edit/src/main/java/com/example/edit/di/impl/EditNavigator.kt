package com.example.edit.di.impl

import androidx.fragment.app.FragmentActivity
import com.example.edit.ui.EditNavigation

class EditNavigator : EditNavigation {
    override fun closeSelf(activity: FragmentActivity) {
        activity.finish()
    }
}