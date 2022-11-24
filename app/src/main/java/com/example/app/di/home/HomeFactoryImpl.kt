package com.example.app.di.home

import com.example.app.componentprovider.homeComponent
import com.example.home.di.HomeFactory
import com.example.home.di.HomeViewModelFactory

class HomeFactoryImpl : HomeFactory {
    override val viewModelFactory: HomeViewModelFactory
        get() = homeComponent.provideViewModelFactory()
}