package com.example.app.di.home

import com.example.home.di.HomeViewModelFactory
import com.example.home.ui.HomeNavigation
import dagger.Subcomponent

@Subcomponent(modules = [HomeModule::class])
@HomeScope
interface HomeComponent {
    fun provideNavigation(): HomeNavigation
    fun provideViewModelFactory(): HomeViewModelFactory
}