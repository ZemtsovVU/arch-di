package com.example.app.di.home

import com.example.app.componentprovider.createHomeComponent
import com.example.app.componentprovider.releaseHomeComponent
import com.example.utils.ModuleLifecycle

class HomeLifecycle : ModuleLifecycle {
    override fun onStarted() = createHomeComponent()
    override fun onFinished() = releaseHomeComponent()
}