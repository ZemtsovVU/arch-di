package com.example.app.di.edit

import com.example.app.navigation.EditNavigator
import com.example.edit.di.EditViewModelFactory
import com.example.edit.domain.EditInteractor
import com.example.edit.ui.EditNavigation
import dagger.Module
import dagger.Provides

@Module
class EditModule {

    @Provides
    @EditScope
    fun provideNavigation(): EditNavigation {
        return EditNavigator()
    }

    @Provides
    @EditScope
    fun provideViewModelFactory(interactor: EditInteractor): EditViewModelFactory {
        return EditViewModelFactory(interactor)
    }

    @Provides
    @EditScope
    fun provideInteractor(): EditInteractor {
        return EditInteractor()
    }
}