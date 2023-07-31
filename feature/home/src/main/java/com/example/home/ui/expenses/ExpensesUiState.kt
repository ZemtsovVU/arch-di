package com.example.home.ui.expenses

data class ExpensesUiState(
    val isCorrected: Boolean = false,
    val correctedDayAmount: Int = -1
)