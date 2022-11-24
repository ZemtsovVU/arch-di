package com.example.app.componentprovider

import com.example.app.appComponent
import com.example.app.di.home.HomeComponent

private var _homeComponent: HomeComponent? = null
val homeComponent: HomeComponent get() = checkNotNull(_homeComponent)

fun plusHomeComponent() {
    if (_homeComponent == null) {
        _homeComponent = appComponent?.plusHomeComponent()
    }
}

fun clearHomeComponent() {
    _homeComponent = null
}