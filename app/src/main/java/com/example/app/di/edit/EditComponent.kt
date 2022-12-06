package com.example.app.di.edit

import com.example.app.di.AppComponent
import com.example.edit.di.EditViewModelFactory
import com.example.edit.ui.EditNavigation
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [EditModule::class])
@EditScope
interface EditComponent {
    fun provideNavigation(): EditNavigation
    fun provideViewModelFactory(): EditViewModelFactory
}