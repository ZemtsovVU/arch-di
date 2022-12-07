package com.example.app.di

import com.example.datasource.LocalBudgetDataSource
import com.example.sharedcontracts.BudgetDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Provides
    @Singleton
    fun provideLocalBudgetDataSource(): BudgetDataSource {
        return LocalBudgetDataSource()
    }
}