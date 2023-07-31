package com.example.home.ui.home

import androidx.fragment.app.FragmentActivity

interface HomeNavigation {
    fun onHomeScreenComplete(
        activity: FragmentActivity,
        completionReason: HomeCompletionReason,
        resultCallback: (correctedDayAmount: Int) -> Unit = {}
    )
}