package com.example.app.di.edit

import com.example.edit.di.EditViewModelFactory
import com.example.edit.domain.EditInteractor
import dagger.Module
import dagger.Provides

@Module
class EditModule {

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