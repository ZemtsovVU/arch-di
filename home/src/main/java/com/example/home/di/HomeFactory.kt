package com.example.home.di

import com.example.home.ui.HomeNavigation

interface HomeFactory {
    val navigation: HomeNavigation
    val viewModelFactory: HomeViewModelFactory
}