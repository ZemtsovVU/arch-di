package com.example.demo.navigation

import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import com.example.home.HomeNavigation
import com.example.home.R
import com.example.home.ui.expenses.ExpensesFragment

class HomeNavigator : HomeNavigation {

    override fun openExpenses(
        activity: FragmentActivity,
        dayAmount: Int,
        resultCallback: (correctedDayAmount: Int) -> Unit
    ) {
        // либо Cicerone resultListener
        activity.supportFragmentManager.setFragmentResultListener(
            "a",
            activity
        ) { requestKey, bundle ->
            val correctedDayAmount = bundle.getInt("b")
            resultCallback(correctedDayAmount)
        }
        activity.supportFragmentManager.commit {
            add(R.id.flContainer, ExpensesFragment(dayAmount))
            addToBackStack(null)
        }
    }

    override fun expensesSaved(activity: FragmentActivity) {
        activity.supportFragmentManager.popBackStack()
    }

    override fun openEditScreen(activity: FragmentActivity) {
        Toast.makeText(
            activity,
            "It'a a Demo. Edit screen not available.",
            Toast.LENGTH_SHORT
        ).show()
    }
}