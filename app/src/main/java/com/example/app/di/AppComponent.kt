package com.example.app.di

import com.example.app.di.home.HomeComponent
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, DataSourceModule::class])
@Singleton
interface AppComponent {
    fun plusHomeComponent(): HomeComponent
}