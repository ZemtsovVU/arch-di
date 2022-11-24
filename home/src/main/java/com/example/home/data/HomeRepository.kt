package com.example.home.data

import com.example.sharedcontracts.BudgetDataSource

class HomeRepository(
    private val localBudgetDataSource: BudgetDataSource
) {

    suspend fun getMonthAmount(): Int {
        return localBudgetDataSource.getMonthAmount()
    }

    suspend fun getDaysInMonth(): Int {
        return localBudgetDataSource.getDaysInMonth()
    }
}