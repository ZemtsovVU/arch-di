package com.example.home.ui.home

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.utils.navigation.observer.ResultObservable

interface HomeNavigation : ResultObservable<Int, Int> {
    fun onHomeScreenComplete(
        activity: FragmentActivity,
        completionReason: HomeCompletionReason,
//        resultCallback: (bundle: Bundle) -> Unit = {}
    )
}