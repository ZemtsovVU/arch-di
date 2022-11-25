package com.example.app.di.edit

import com.example.app.componentprovider.clearEditComponent
import com.example.app.componentprovider.plusEditComponent
import com.example.utils.ModuleLifecycle

class EditLifecycle : ModuleLifecycle {
    override fun onStarted() = plusEditComponent()
    override fun onFinished() = clearEditComponent()
}