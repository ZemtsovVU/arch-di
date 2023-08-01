package com.example.utils.navigation

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

interface Navigation<T> {
    fun onComplete(
        activity: FragmentActivity,
        completionReason: T,
        resultCallback: (bundle: Bundle) -> Unit = {}
    )
}