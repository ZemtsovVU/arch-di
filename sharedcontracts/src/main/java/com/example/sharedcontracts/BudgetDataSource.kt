package com.example.sharedcontracts

interface BudgetDataSource {
    fun getMonthAmount(): Int
    fun getDaysInMonth(): Int
}