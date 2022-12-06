package com.example.app.di.edit

import com.example.app.componentprovider.createEditComponent
import com.example.app.componentprovider.releaseEditComponent
import com.example.utils.ModuleLifecycle

class EditLifecycle : ModuleLifecycle {
    override fun onStarted() = createEditComponent()
    override fun onFinished() = releaseEditComponent()
}