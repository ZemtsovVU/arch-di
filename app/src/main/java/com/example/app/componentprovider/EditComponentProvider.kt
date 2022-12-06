package com.example.app.componentprovider

import com.example.app.appComponent
import com.example.app.di.edit.DaggerEditComponent
import com.example.app.di.edit.EditComponent

private var _editComponent: EditComponent? = null
val editComponent: EditComponent get() = checkNotNull(_editComponent)

fun createEditComponent() {
    if (_editComponent == null) {
        _editComponent = DaggerEditComponent.builder()
            .appComponent(appComponent)
            .build()
    }
}

fun releaseEditComponent() {
    _editComponent = null
}