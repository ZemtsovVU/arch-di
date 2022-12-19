package com.example.dataapi

interface BudgetDataSource {
    fun getMonthAmount(): Int
    fun getDaysInMonth(): Int
}