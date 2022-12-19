package com.example.datamain.di

import com.example.dataapi.BudgetDataSource
import com.example.dataimpl.LocalBudgetDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideBudgetDataSource(): BudgetDataSource {
        return LocalBudgetDataSource()
    }
}