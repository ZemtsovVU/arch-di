package com.example.home.di

import com.example.home.HomeNavigationFacade
import com.example.home.di.impl.HomeViewModelFactory
import com.example.utils.ModuleScope
import dagger.Component

@ModuleScope
@Component(modules = [HomeModule::class])
interface HomeComponent {
    fun provideNavigation(): HomeNavigationFacade
    fun provideViewModelFactory(): HomeViewModelFactory
}