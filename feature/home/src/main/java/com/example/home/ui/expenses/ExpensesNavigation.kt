package com.example.home.ui.expenses

import androidx.fragment.app.FragmentActivity

interface ExpensesNavigation {
    fun onExpensesScreenComplete(
        activity: FragmentActivity,
        completionReason: ExpensesCompletionReason
    )
}