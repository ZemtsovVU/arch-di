package com.example.home.data

class HomeRepository(
    private val localBudgetDataSource: com.example.dataapi.BudgetDataSource
) {

    suspend fun getMonthAmount(): Int {
        return localBudgetDataSource.getMonthAmount()
    }

    suspend fun getDaysInMonth(): Int {
        return localBudgetDataSource.getDaysInMonth()
    }
}