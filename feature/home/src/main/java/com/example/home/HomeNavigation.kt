package com.example.home

import androidx.fragment.app.FragmentActivity
import com.example.home.ui.expenses.ExpensesCompletionReason
import com.example.home.ui.home.HomeCompletionReason

interface HomeNavigation {

    fun onHomeScreenComplete(
        activity: FragmentActivity,
        completionReason: HomeCompletionReason,
        resultCallback: (correctedDayAmount: Int) -> Unit = {}
    )

    fun onExpensesScreenComplete(
        activity: FragmentActivity,
        completionReason: ExpensesCompletionReason
    )
}