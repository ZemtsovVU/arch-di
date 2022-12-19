package com.example.edit.di

import com.example.edit.di.impl.EditNavigator
import com.example.edit.di.impl.EditViewModelFactory
import com.example.edit.domain.EditInteractor
import com.example.edit.ui.EditNavigation
import com.example.utils.ModuleScope
import dagger.Module
import dagger.Provides

@Module
class EditModule {

    @Provides
    @ModuleScope
    fun provideNavigation(): EditNavigation {
        return EditNavigator()
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