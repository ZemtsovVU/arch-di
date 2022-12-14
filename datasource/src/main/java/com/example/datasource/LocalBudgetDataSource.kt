package com.example.datasource

import com.example.sharedcontracts.BudgetDataSource

class LocalBudgetDataSource : BudgetDataSource {

    override fun getMonthAmount(): Int {
        return 40_000
    }

    override fun getDaysInMonth(): Int {
        return 30
    }
}