package com.example.home

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

interface HomeNavigation {
    // todo эти детали реализации (активити, фрагменты) нужно скрыть
    fun openExpenses(supportFragmentManager: FragmentManager, @IdRes containerId: Int)
    fun expensesSaved(supportFragmentManager: FragmentManager, @IdRes containerId: Int)
    fun openEditScreen(activity: FragmentActivity)
}