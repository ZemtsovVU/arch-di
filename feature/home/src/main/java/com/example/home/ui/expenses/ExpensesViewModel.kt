package com.example.home.ui.expenses

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ExpensesViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ExpensesUiState())
    val uiState: StateFlow<ExpensesUiState> = _uiState.asStateFlow()

    fun onCorrectButtonClicked(dayAmount: Int) {
        // call some business logic in interactor...
        val corrected = dayAmount + 100
        _uiState.update { it.copy(isCorrected = true, correctedDayAmount = corrected) }
    }
}