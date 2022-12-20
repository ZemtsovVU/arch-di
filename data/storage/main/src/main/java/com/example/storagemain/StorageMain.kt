package com.example.storagemain

import com.example.storagemain.di.DaggerStorageComponent
import com.example.storagemain.di.StorageComponent

object StorageMain {

    private var _component: StorageComponent? = null
    val component: StorageComponent get() = requireNotNull(_component) { "Need to initialize first." }

    fun initialize() {
        _component = DaggerStorageComponent.create()
    }

    fun release() {
        _component = null
    }
}