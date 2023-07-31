package com.example.home.ui.home

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

interface HomeNavigation {
    fun onHomeScreenComplete(
        activity: FragmentActivity,
        completionReason: HomeCompletionReason,
        resultCallback: (bundle: Bundle) -> Unit = {}
    )
}