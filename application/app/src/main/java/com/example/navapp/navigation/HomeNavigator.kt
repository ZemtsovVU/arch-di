package com.example.navapp.navigation

import android.content.Intent
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.edit.EditActivity
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
        activity.startActivity(
            Intent(activity, EditActivity::class.java)
        )
    }
}