package com.example.demo.navigation

import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import com.example.home.HomeNavigation
import com.example.home.R
import com.example.home.ui.expenses.ExpensesCompletionReason
import com.example.home.ui.expenses.ExpensesFragment
import com.example.home.ui.home.HomeCompletionReason

class HomeNavigator : HomeNavigation {

    override fun onHomeScreenComplete(
        activity: FragmentActivity,
        completionReason: HomeCompletionReason,
        resultCallback: (correctedDayAmount: Int) -> Unit
    ) {
        when (completionReason) {
            is HomeCompletionReason.OpenExpenses -> {
                // либо Cicerone resultListener
                activity.supportFragmentManager.setFragmentResultListener(
                    "a",
                    activity
                ) { requestKey, bundle ->
                    val correctedDayAmount = bundle.getInt("b")
                    resultCallback(correctedDayAmount)
                }
                activity.supportFragmentManager.commit {
                    add(R.id.flContainer, ExpensesFragment(completionReason.dayAmount))
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