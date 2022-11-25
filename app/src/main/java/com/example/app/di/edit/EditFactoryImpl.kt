package com.example.app.di.edit

import com.example.app.componentprovider.editComponent
import com.example.edit.di.EditFactory
import com.example.edit.di.EditViewModelFactory
import com.example.edit.ui.EditNavigation

class EditFactoryImpl : EditFactory {
    override val navigation: EditNavigation
        get() = editComponent.provideNavigation()
    override val viewModelFactory: EditViewModelFactory
        get() = editComponent.provideViewModelFactory()
}