package com.example.datamain.di

import com.example.dataapi.BudgetDataSource
import dagger.Component
import javax.inject.Singleton

// TODO Нужен ли при таком подходе скоуп?
@Singleton
@Component(modules = [DataModule::class])
interface DataComponent {
    fun provideBudgetDataSource(): BudgetDataSource
}