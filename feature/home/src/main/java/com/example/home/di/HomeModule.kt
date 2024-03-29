package com.example.home.di

import com.example.home.HomeNavigationFacade
import com.example.home.data.HomeRepository
import com.example.home.di.impl.HomeViewModelFactory
import com.example.home.domain.HomeInteractor
import com.example.storageapi.BudgetStorage
import com.example.storagemain.StorageMain
import com.example.utils.ModuleScope
import dagger.Module
import dagger.Provides

@Module
class HomeModule(private val navigation: HomeNavigationFacade) {

    @ModuleScope
    @Provides
    fun provideNavigation(): HomeNavigationFacade {
        return navigation
    }

    @ModuleScope
    @Provides
    fun provideViewModelFactory(interactor: HomeInteractor): HomeViewModelFactory {
        return HomeViewModelFactory(interactor)
    }

    @ModuleScope
    @Provides
    fun provideInteractor(repository: HomeRepository): HomeInteractor {
        return HomeInteractor(repository)
    }

    @ModuleScope
    @Provides
    fun provideRepository(budgetStorage: BudgetStorage): HomeRepository {
        return HomeRepository(budgetStorage)
    }

    @ModuleScope
    @Provides
    fun provideBudgetStorage(): BudgetStorage {
        return StorageMain.component.provideBudgetStorage()
    }
}