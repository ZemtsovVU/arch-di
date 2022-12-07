package com.example.app

import android.app.Application
import com.example.app.di.AppModule
import com.example.app.di.DaggerAppComponent
import com.example.app.di.edit.EditFactoryImpl
import com.example.app.di.edit.EditLifecycle
import com.example.app.di.home.HomeFactoryImpl
import com.example.app.di.home.HomeLifecycle
import com.example.edit.di.EditDelivery
import com.example.home.di.HomeDelivery
import com.example.utils.DeliveryGuard

@OptIn(DeliveryGuard::class)
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
        initHomeDelivery()
        initEditDelivery()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .build()
    }

    private fun initHomeDelivery() {
        with(HomeDelivery) {
            lifecycle = HomeLifecycle()
            factory = HomeFactoryImpl()
        }
    }

    private fun initEditDelivery() {
        with(EditDelivery) {
            lifecycle = EditLifecycle()
            factory = EditFactoryImpl()
        }
    }
}