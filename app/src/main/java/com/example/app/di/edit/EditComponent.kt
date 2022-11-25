package com.example.app.di.edit

import com.example.edit.di.EditViewModelFactory
import com.example.edit.ui.EditNavigation
import dagger.Subcomponent

@Subcomponent(modules = [EditModule::class])
@EditScope
interface EditComponent {
    fun provideNavigation(): EditNavigation
    fun provideViewModelFactory(): EditViewModelFactory
}