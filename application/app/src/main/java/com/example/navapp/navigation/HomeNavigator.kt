package com.example.navapp.navigation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import com.example.edit.EditActivity
import com.example.home.ui.HomeCompletionReason
import com.example.home.R
import com.example.home.ui.expenses.ExpensesFragment
import com.example.home.ui.expenses.ExpensesSaved
import com.example.home.ui.home.OpenEditScreen
import com.example.home.ui.home.OpenExpenses
import com.example.utils.navigation.Navigation

class HomeNavigator : Navigation<HomeCompletionReason> {

    override fun onComplete(
        activity: FragmentActivity,
        completionReason: HomeCompletionReason,
        resultCallback: (bundle: Bundle) -> Unit
    ) {
        when (completionReason) {
            is OpenExpenses -> {
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

            is ExpensesSaved -> {
                activity.supportFragmentManager.popBackStack()
            }

            is OpenEditScreen -> {
                activity.startActivity(Intent(activity, EditActivity::class.java))
            }
        }
    }
}