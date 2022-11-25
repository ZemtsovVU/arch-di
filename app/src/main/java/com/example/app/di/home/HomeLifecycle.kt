package com.example.app.di.home

import com.example.app.componentprovider.clearHomeComponent
import com.example.app.componentprovider.plusHomeComponent
import com.example.utils.ModuleLifecycle
import java.io.Serializable

class HomeLifecycle : ModuleLifecycle, Serializable {
    override fun onStarted() = plusHomeComponent()
    override fun onFinished() = clearHomeComponent()
}