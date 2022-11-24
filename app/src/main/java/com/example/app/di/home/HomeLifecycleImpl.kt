package com.example.app.di.home

import com.example.app.componentprovider.clearHomeComponent
import com.example.app.componentprovider.plusHomeComponent
import com.example.home.di.HomeLifecycle

class HomeLifecycleImpl : HomeLifecycle {
    override fun onCreated() = plusHomeComponent()
    override fun onDestroyed() = clearHomeComponent()
}