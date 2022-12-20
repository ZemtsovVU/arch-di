package com.example.storagemain.di

import com.example.storageapi.BudgetStorage
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [StorageModule::class])
interface StorageComponent {
    fun provideBudgetStorage(): BudgetStorage
}