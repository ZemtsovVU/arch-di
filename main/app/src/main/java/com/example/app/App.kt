package com.example.app

import android.app.Application
import com.example.datamain.DataMain
import com.example.platform.PlatformMain

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initModules()
    }

    private fun initModules() {
        PlatformMain.initialize(applicationContext)
        DataMain.initialize()
    }
}