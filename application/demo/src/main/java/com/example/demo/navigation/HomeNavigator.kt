package com.example.demo.navigation

import android.widget.Toast
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.home.HomeNavigation
import com.example.home.ui.expenses.ExpensesFragment

class HomeNavigator : HomeNavigation {

    override fun openExpenses(supportFragmentManager: FragmentManager, containerId: Int) {
        supportFragmentManager.commit {
            add(containerId, ExpensesFragment())
            addToBackStack(null)
        }
    }

    override fun expensesSaved(supportFragmentManager: FragmentManager, @IdRes containerId: Int) {
        supportFragmentManager.popBackStack()
    }

    override fun openEditScreen(activity: FragmentActivity) {
        Toast.makeText(
            activity,
            "It'a a Demo. Edit screen not available.",
            Toast.LENGTH_SHORT
        ).show()
    }
}