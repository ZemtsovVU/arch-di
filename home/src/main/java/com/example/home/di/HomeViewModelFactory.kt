package com.example.home.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.home.domain.HomeInteractor
import com.example.home.ui.HomeViewModel

class HomeViewModelFactory(
    private val interactor: HomeInteractor
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(interactor) as T
    }
}