package com.example.app.di

import com.example.datasource.LocalBudgetDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Provides
    @Singleton
    fun provideLocalBudgetDataSource(): com.example.sharedcontracts.BudgetDataSource {
        return LocalBudgetDataSource()
    }
}