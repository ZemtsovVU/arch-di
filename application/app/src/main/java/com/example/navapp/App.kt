package com.example.navapp

import android.app.Application
import com.example.navapp.navigation.EditNavigator
import com.example.navapp.navigation.HomeNavigator
import com.example.platform.PlatformMain
import com.example.storagemain.StorageMain
import com.example.utils.navigation.NavigationFactory
import com.example.utils.navigation.NavigationFactoryEnum
import com.example.utils.navigation.NavigationFactoryEnum.EDIT
import com.example.utils.navigation.NavigationFactoryEnum.HOME

class App : Application(), NavigationFactory {

    override fun onCreate() {
        super.onCreate()
        initModules()
    }

    private fun initModules() {
        PlatformMain.initialize(applicationContext)
        StorageMain.initialize()
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T> getNavigation(enum: NavigationFactoryEnum): T {
        return when (enum) {
            HOME -> HomeNavigator() as T
            EDIT -> EditNavigator() as T
        }
    }
}