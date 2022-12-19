package com.example.edit.di.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.edit.domain.EditInteractor
import com.example.edit.ui.EditViewModel

class EditViewModelFactory(
    private val interactor: EditInteractor
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EditViewModel(interactor) as T
    }
}