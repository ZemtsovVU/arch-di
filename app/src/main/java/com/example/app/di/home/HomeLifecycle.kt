package com.example.app.di.home

import com.example.app.componentprovider.clearHomeComponent
import com.example.app.componentprovider.plusHomeComponent
import com.example.utils.ModuleLifecycle

class HomeLifecycle : ModuleLifecycle {
    override fun onStarted() = plusHomeComponent()
    override fun onFinished() = clearHomeComponent()
}