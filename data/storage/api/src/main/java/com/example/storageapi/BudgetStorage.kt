package com.example.storageapi

interface BudgetStorage {
    fun getMonthAmount(): Int
    fun getDaysInMonth(): Int
}