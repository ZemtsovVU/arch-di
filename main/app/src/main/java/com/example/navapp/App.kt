package com.example.navapp

import android.app.Application
import com.example.datamain.DataMain
import com.example.navigation.NavigationMain
import com.example.platform.PlatformMain

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initModules()
    }

    private fun initModules() {
        NavigationMain.initialize(AppNavigation())
        PlatformMain.initialize(applicationContext)
        DataMain.initialize()
    }
}