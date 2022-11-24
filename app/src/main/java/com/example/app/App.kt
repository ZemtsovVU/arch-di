package com.example.app

import android.app.Application
import com.example.app.di.AppModule
import com.example.app.di.DaggerAppComponent
import com.example.app.di.home.HomeFactoryImpl
import com.example.app.di.home.HomeLifecycleImpl
import com.example.home.di.HomeDelivery

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
        initHomeDelivery()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .build()
    }

    private fun initHomeDelivery() {
        with(HomeDelivery) {
            lifecycle = HomeLifecycleImpl()
            factory = HomeFactoryImpl()
        }
    }
}