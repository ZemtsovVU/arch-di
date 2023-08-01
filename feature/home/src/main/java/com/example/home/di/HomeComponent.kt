package com.example.home.di

import com.example.home.ui.HomeCompletionReason
import com.example.home.di.impl.HomeViewModelFactory
import com.example.utils.ModuleScope
import com.example.utils.navigation.Navigation
import dagger.Component

@ModuleScope
@Component(modules = [HomeModule::class])
interface HomeComponent {
    fun provideNavigation(): Navigation<HomeCompletionReason>
    fun provideViewModelFactory(): HomeViewModelFactory
}