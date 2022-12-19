package com.example.platform

import android.annotation.SuppressLint
import android.content.Context

/**
 * В качестве примера.
 * https://developer.android.com/reference/android/app/Application
 */
@SuppressLint("StaticFieldLeak")
object PlatformMain {

    private var _appContext: Context? = null
    val appContext: Context get() = requireNotNull(_appContext) { "Need to initialize first." }

    fun initialize(applicationContext: Context) {
        _appContext = applicationContext
    }

    fun release() {
        _appContext = null
    }
}