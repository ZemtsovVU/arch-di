package com.example.app.di.edit

import com.example.app.componentprovider.editComponent
import com.example.edit.di.EditFactory
import com.example.edit.di.EditViewModelFactory

class EditFactoryImpl : EditFactory {
    override val viewModelFactory: EditViewModelFactory
        get() = editComponent.provideViewModelFactory()
}