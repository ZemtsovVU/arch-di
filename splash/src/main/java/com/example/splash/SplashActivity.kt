package com.example.splash

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager

// TODO https://developer.android.com/develop/ui/views/launch/splash-screen
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    companion object {
        const val NAVIGATION_EXTRA_KEY = "SPLASH_NAVIGATION"
    }

    private val broadcastManager by lazy {
        LocalBroadcastManager.getInstance(this)
    }
    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val nav = intent.getSerializableExtra(NAVIGATION_EXTRA_KEY) as SplashNavigation
            nav.openHomeScreen(this@SplashActivity)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        broadcastManager.registerReceiver(broadcastReceiver, IntentFilter(NAVIGATION_EXTRA_KEY))
    }

    override fun onDestroy() {
        super.onDestroy()
        broadcastManager.unregisterReceiver(broadcastReceiver)
    }
}