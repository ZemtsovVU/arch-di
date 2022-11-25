package com.example.app.di.home

import com.example.home.di.HomeViewModelFactory
import dagger.Subcomponent

@Subcomponent(modules = [HomeModule::class])
@HomeScope
interface HomeComponent {
    fun provideViewModelFactory(): HomeViewModelFactory
}