package com.example.app.di.home

import com.example.home.data.HomeRepository
import com.example.home.di.HomeViewModelFactory
import com.example.home.domain.HomeInteractor
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    @HomeScope
    fun provideViewModelFactory(interactor: HomeInteractor): HomeViewModelFactory {
        return HomeViewModelFactory(interactor)
    }

    @Provides
    @HomeScope
    fun provideInteractor(repository: HomeRepository): HomeInteractor {
        return HomeInteractor(repository)
    }

    @Provides
    @HomeScope
    fun provideRepository(localBudgetDataSource: com.example.sharedcontracts.BudgetDataSource): HomeRepository {
        return HomeRepository(localBudgetDataSource)
    }
}