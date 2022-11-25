package com.example.app.di.edit

import com.example.edit.di.EditViewModelFactory
import dagger.Subcomponent

@Subcomponent(modules = [EditModule::class])
@EditScope
interface EditComponent {
    fun provideViewModelFactory(): EditViewModelFactory
}