package com.example.app.di.home

import com.example.app.componentprovider.homeComponent
import com.example.home.di.HomeFactory
import com.example.home.di.HomeViewModelFactory
import com.example.home.ui.HomeNavigation

class HomeFactoryImpl : HomeFactory {
    override val navigation: HomeNavigation
        get() = homeComponent.provideNavigation()
    override val viewModelFactory: HomeViewModelFactory
        get() = homeComponent.provideViewModelFactory()
}