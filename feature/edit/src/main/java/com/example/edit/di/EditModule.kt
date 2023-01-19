package com.example.edit.di

import com.example.edit.EditNavigation
import com.example.edit.di.impl.EditViewModelFactory
import com.example.edit.domain.EditInteractor
import com.example.utils.ModuleScope
import dagger.Module
import dagger.Provides

@Module
class EditModule(private val navigation: EditNavigation) {

    @Provides
    @ModuleScope
    fun provideNavigation(): EditNavigation {
        return navigation
    }

    @Provides
    @ModuleScope
    fun provideViewModelFactory(interactor: EditInteractor): EditViewModelFactory {
        return EditViewModelFactory(interactor)
    }

    @Provides
    @ModuleScope
    fun provideInteractor(): EditInteractor {
        return EditInteractor()
    }
}