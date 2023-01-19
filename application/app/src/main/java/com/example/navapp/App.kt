package com.example.navapp

import android.app.Application
import com.example.platform.PlatformMain
import com.example.storagemain.StorageMain
import com.example.utils.NavigationProvider

class App : Application(), NavigationProvider {

    private val navigation: NavigationFacade = AppNavigation()

    override fun onCreate() {
        super.onCreate()
        initModules()
    }

    private fun initModules() {
        PlatformMain.initialize(applicationContext)
        StorageMain.initialize()
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T> getNavigation(): T {
        return navigation as T
    }
}