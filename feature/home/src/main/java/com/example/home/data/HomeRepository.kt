package com.example.home.data

import com.example.storageapi.BudgetStorage

class HomeRepository(
    private val budgetStorage: BudgetStorage
) {

    suspend fun getMonthAmount(): Int {
        return budgetStorage.getMonthAmount()
    }

    suspend fun getDaysInMonth(): Int {
        return budgetStorage.getDaysInMonth()
    }
}