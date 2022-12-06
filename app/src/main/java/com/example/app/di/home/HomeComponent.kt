package com.example.app.di.home

import com.example.app.di.AppComponent
import com.example.home.di.HomeViewModelFactory
import com.example.home.ui.HomeNavigation
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [HomeModule::class])
@HomeScope
interface HomeComponent {
    fun provideNavigation(): HomeNavigation
    fun provideViewModelFactory(): HomeViewModelFactory
}