package com.example.edit.di

import com.example.edit.ui.EditNavigation

interface EditFactory {
    val navigation: EditNavigation
    val viewModelFactory: EditViewModelFactory
}