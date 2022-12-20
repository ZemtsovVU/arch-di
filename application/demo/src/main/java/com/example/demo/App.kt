package com.example.demo

import android.app.Application
import com.example.navigation.NavigationMain
import com.example.storagemain.StorageMain

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initModules()
    }

    private fun initModules() {
        NavigationMain.initialize(AppNavigation())
        StorageMain.initialize()
    }
}