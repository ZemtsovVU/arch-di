package com.example.app.di.edit

import com.example.app.componentprovider.clearEditComponent
import com.example.app.componentprovider.plusEditComponent
import com.example.utils.ModuleLifecycle
import java.io.Serializable

class EditLifecycle : ModuleLifecycle, Serializable {
    override fun onStarted() = plusEditComponent()
    override fun onFinished() = clearEditComponent()
}