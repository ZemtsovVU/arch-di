package com.example.demo

import android.app.Application
import com.example.datamain.DataMain

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initModules()
    }

    private fun initModules() {
        DataMain.initialize()
    }
}