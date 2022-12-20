package com.example.storagemain.di

import com.example.storageapi.BudgetStorage
import com.example.storageimpl.FakeBudgetStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    @Singleton
    @Provides
    fun provideBudgetStorage(): BudgetStorage {
        return FakeBudgetStorage()
    }
}