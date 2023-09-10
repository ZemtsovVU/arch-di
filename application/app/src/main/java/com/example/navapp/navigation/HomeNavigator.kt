package com.example.navapp.navigation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import com.example.edit.EditActivity
import com.example.home.HomeNavigationFacade
import com.example.home.R
import com.example.home.ui.expenses.ExpensesCompletionReason
import com.example.home.ui.expenses.ExpensesFragment
import com.example.home.ui.home.HomeCompletionReason
import com.example.utils.navigation.observer.ResultObserver

class HomeNavigator : HomeNavigationFacade {

    private val resultObservers = mutableListOf<ResultObserver<Int, Int>>()

    override fun addObserver(resultObserver: ResultObserver<Int, Int>) {
        resultObservers.add(resultObserver)
    }

    override fun removeObserver(resultObserver: ResultObserver<Int, Int>) {
        resultObservers.remove(resultObserver)
    }

    override fun notifyObservers(key: Int, value: Int) {
        resultObservers.forEach { it.onResult(key, value) }
    }

    override fun onHomeScreenComplete(
        activity: FragmentActivity,
        completionReason: HomeCompletionReason,
//        resultCallback: (bundle: Bundle) -> Unit
    ) {
        when (completionReason) {
            is HomeCompletionReason.OpenExpenses -> {
                // либо Cicerone resultListener
                activity.supportFragmentManager.setFragmentResultListener(
                    "a",
                    activity
                ) { _, bundle ->
//                    resultCallback(bundle)
                    notifyObservers()
                }
                activity.supportFragmentManager.commit {
                    replace(R.id.flContainer, ExpensesFragment(completionReason.dayAmount))
                    addToBackStack(null)
                }
            }

            is HomeCompletionReason.OpenEditScreen -> {
                activity.startActivity(Intent(activity, EditActivity::class.java))
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