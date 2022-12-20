package com.example.demo

import android.app.Application
import com.example.datamain.DataMain
import com.example.navigation.NavigationMain

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initModules()
    }

    private fun initModules() {
        NavigationMain.initialize(AppNavigation())
        DataMain.initialize()
    }
}