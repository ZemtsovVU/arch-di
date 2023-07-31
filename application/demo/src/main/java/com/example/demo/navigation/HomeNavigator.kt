package com.example.demo.navigation

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import com.example.home.HomeNavigationFacade
import com.example.home.R
import com.example.home.ui.expenses.ExpensesCompletionReason
import com.example.home.ui.expenses.ExpensesFragment
import com.example.home.ui.home.HomeCompletionReason

class HomeNavigator : HomeNavigationFacade {

    override fun onHomeScreenComplete(
        activity: FragmentActivity,
        completionReason: HomeCompletionReason,
        resultCallback: (bundle: Bundle) -> Unit
    ) {
        when (completionReason) {
            is HomeCompletionReason.OpenExpenses -> {
                // либо Cicerone resultListener
                activity.supportFragmentManager.setFragmentResultListener(
                    "a",
                    activity
                ) { _, bundle ->
                    resultCallback(bundle)
                }
                activity.supportFragmentManager.commit {
                    replace(R.id.flContainer, ExpensesFragment(completionReason.dayAmount))
                    addToBackStack(null)
                }
            }

            is HomeCompletionReason.OpenEditScreen -> {
                Toast.makeText(
                    activity,
                    "It'a a Demo. Edit screen not available.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onExpensesScreenComplete(
        activity: FragmentActivity,
        completionReason: ExpensesCompletionReason
    ) {
        when (completionReason) {
            ExpensesCompletionReason.ExpensesSaved -> {
                activity.supportFragmentManager.popBackStack()
            }
        }
    }
}