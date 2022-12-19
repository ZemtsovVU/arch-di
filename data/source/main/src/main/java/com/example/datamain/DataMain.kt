package com.example.datamain

import com.example.datamain.di.DaggerDataComponent
import com.example.datamain.di.DataComponent

object DataMain {

    private var _component: DataComponent? = null
    val component: DataComponent get() = requireNotNull(_component) { "Need to initialize first." }

    fun initialize() {
        _component = DaggerDataComponent.create()
    }

    fun release() {
        _component = null
    }
}