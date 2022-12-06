package com.example.app.componentprovider

import com.example.app.appComponent
import com.example.app.di.home.DaggerHomeComponent
import com.example.app.di.home.HomeComponent

private var _homeComponent: HomeComponent? = null
val homeComponent: HomeComponent get() = checkNotNull(_homeComponent)

fun createHomeComponent() {
    if (_homeComponent == null) {
        _homeComponent = DaggerHomeComponent.builder()
            .appComponent(appComponent)
            .build()
    }
}

fun releaseHomeComponent() {
    _homeComponent = null
}