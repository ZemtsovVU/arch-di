package com.example.demo

import android.app.Application
import com.example.storagemain.StorageMain

open class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initModules()
    }

    private fun initModules() {
        StorageMain.initialize()
    }
}