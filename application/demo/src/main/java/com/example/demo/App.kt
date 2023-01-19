package com.example.demo

import android.app.Application
import com.example.home.HomeNavigation
import com.example.storagemain.StorageMain
import com.example.utils.NavigationProvider

class App : Application(), NavigationProvider {

    private val navigation: HomeNavigation = AppNavigation()

    override fun onCreate() {
        super.onCreate()
        initModules()
    }

    private fun initModules() {
        StorageMain.initialize()
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T> getNavigation(): T {
        return navigation as T
    }
}