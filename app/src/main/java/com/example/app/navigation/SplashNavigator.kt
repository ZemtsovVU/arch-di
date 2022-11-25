package com.example.app.navigation

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.example.app.di.home.HomeFactoryImpl
import com.example.app.di.home.HomeLifecycle
import com.example.home.HomeActivity
import com.example.splash.SplashNavigation
import java.io.Serializable

class SplashNavigator : SplashNavigation, Serializable {
    override fun openHomeScreen(activity: FragmentActivity) {
        activity.startActivity(
            Intent(activity, HomeActivity::class.java).apply {
                putExtra(HomeActivity.LIFECYCLE_EXTRA_KEY, HomeLifecycle())
                putExtra(HomeActivity.FACTORY_EXTRA_KEY, HomeFactoryImpl())
            }
        )
        activity.finish()
    }
}