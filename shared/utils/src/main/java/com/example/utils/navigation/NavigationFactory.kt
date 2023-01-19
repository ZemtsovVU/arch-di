package com.example.utils.navigation

interface NavigationFactory {
    // Можно передавать и тип класса, но тогда в compile-time не будет проверки.
    fun <T> getNavigation(enum: NavigationFactoryEnum): T
}