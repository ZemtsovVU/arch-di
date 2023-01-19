package com.example.navapp

import android.app.Application
import com.example.platform.PlatformMain
import com.example.storagemain.StorageMain

open class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initModules()
    }

    private fun initModules() {
        PlatformMain.initialize(applicationContext)
        StorageMain.initialize()
    }
}