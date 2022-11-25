package com.example.app.componentprovider

import com.example.app.appComponent
import com.example.app.di.edit.EditComponent

private var _editComponent: EditComponent? = null
val editComponent: EditComponent get() = checkNotNull(_editComponent)

fun plusEditComponent() {
    if (_editComponent == null) {
        _editComponent = appComponent?.plusEditComponent()
    }
}

fun clearEditComponent() {
    _editComponent = null
}