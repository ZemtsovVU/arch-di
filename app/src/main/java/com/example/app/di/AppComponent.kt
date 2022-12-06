package com.example.app.di

import android.content.Context
import com.example.sharedcontracts.BudgetDataSource
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, DataSourceModule::class])
@Singleton
interface AppComponent {
    fun provideContext(): Context
    fun provideBudgetDataSource(): BudgetDataSource
}