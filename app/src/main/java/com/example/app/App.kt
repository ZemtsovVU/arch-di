package com.example.app

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Bundle
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.app.di.AppModule
import com.example.app.di.DaggerAppComponent
import com.example.app.navigation.SplashNavigator
import com.example.splash.SplashActivity

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
        sendNavigationToSplashScreen()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .build()
    }

    private fun sendNavigationToSplashScreen() {
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) = Unit

            override fun onActivityStarted(activity: Activity) {
                if (activity is SplashActivity) {
                    LocalBroadcastManager.getInstance(activity).sendBroadcast(
                        Intent(SplashActivity.NAVIGATION_EXTRA_KEY).apply {
                            putExtra(SplashActivity.NAVIGATION_EXTRA_KEY, SplashNavigator())
                        }
                    )
                    unregisterActivityLifecycleCallbacks(this)
                }
            }

            override fun onActivityResumed(activity: Activity) = Unit
            override fun onActivityPaused(activity: Activity) = Unit
            override fun onActivityStopped(activity: Activity) = Unit
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) = Unit
            override fun onActivityDestroyed(activity: Activity) = Unit
        })
    }
}