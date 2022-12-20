package com.example.home.di

import com.example.dataapi.BudgetDataSource
import com.example.datamain.DataMain
import com.example.home.data.HomeRepository
import com.example.home.di.impl.HomeViewModelFactory
import com.example.home.domain.HomeInteractor
import com.example.navigation.NavigationMain
import com.example.navigation.features.HomeNavigation
import com.example.utils.ModuleScope
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @ModuleScope
    @Provides
    fun provideNavigation(): HomeNavigation {
        return NavigationMain.navFacade
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
    fun provideRepository(localBudgetDataSource: BudgetDataSource): HomeRepository {
        return HomeRepository(localBudgetDataSource)
    }

    @ModuleScope
    @Provides
    fun provideBudgetDataSource(): BudgetDataSource {
        return DataMain.component.provideBudgetDataSource()
    }
}