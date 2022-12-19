package com.example.home.ui

import androidx.fragment.app.FragmentActivity

// TODO Должен заниматься App, но пока не решена проблема доставки экземпляра.
interface HomeNavigation {
    fun openEditScreen(activity: FragmentActivity)
}