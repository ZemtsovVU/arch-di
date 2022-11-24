package com.example.app.di.home

import com.example.app.di.AppComponent
import com.example.home.domain.HomeInteractor
import com.example.home.data.HomeRepository
import com.example.home.di.HomeViewModelFactory
import dagger.Component
import dagger.Subcomponent

@Subcomponent(modules = [HomeModule::class])
@HomeScope
interface HomeComponent {
    fun provideViewModelFactory(): HomeViewModelFactory
}