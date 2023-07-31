package com.example.home.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.home.domain.HomeInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val interactor: HomeInteractor
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private var _dayAmount: Int = 0
    val dayAmount: Int get() = _dayAmount

    init {
        viewModelScope.launch {
            _dayAmount = interactor.calculateDayAmount()
            _uiState.update { it.copy(dayAmount = dayAmount) }
        }
    }

    fun setCorrectedDayAmount(correctedDayAmount: Int) {
        _dayAmount = correctedDayAmount
        _uiState.update { it.copy(dayAmount = dayAmount) }
    }
}