package com.example.edit.di

import com.example.edit.di.impl.EditViewModelFactory
import com.example.navigation.features.EditNavigation
import com.example.utils.ModuleScope
import dagger.Component

@ModuleScope
@Component(modules = [EditModule::class])
interface EditComponent {
    fun provideNavigation(): EditNavigation
    fun provideViewModelFactory(): EditViewModelFactory
}