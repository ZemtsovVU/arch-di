package com.example.utils

interface NavigationProvider {
    fun <T> getNavigation(): T
}