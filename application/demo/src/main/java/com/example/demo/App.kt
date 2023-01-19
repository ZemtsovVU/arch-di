package com.example.demo

import android.app.Application
import com.example.demo.navigation.HomeNavigator
import com.example.storagemain.StorageMain
import com.example.utils.navigation.NavigationFactory
import com.example.utils.navigation.NavigationFactoryEnum
import com.example.utils.navigation.NavigationFactoryEnum.*

class App : Application(), NavigationFactory {

    override fun onCreate() {
        super.onCreate()
        initModules()
    }

    private fun initModules() {
        StorageMain.initialize()
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T> getNavigation(enum: NavigationFactoryEnum): T {
        return when (enum) {
            HOME -> HomeNavigator() as T
            EDIT -> error("Not supported screen in Demo app.")
        }
    }
}