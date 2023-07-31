package com.example.home

import androidx.fragment.app.FragmentActivity

interface HomeNavigation {

    fun openExpenses(
        activity: FragmentActivity,
        dayAmount: Int,
        resultCallback: (correctedDayAmount: Int) -> Unit
    )

    fun expensesSaved(activity: FragmentActivity)

    fun openEditScreen(activity: FragmentActivity)
}