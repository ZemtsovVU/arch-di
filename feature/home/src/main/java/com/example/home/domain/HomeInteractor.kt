package com.example.home.domain

import com.example.home.data.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeInteractor(
    private val repository: HomeRepository
) {

    suspend fun calculateDayAmount(): Int = withContext(Dispatchers.Default) {
        val monthAmount: Int = repository.getMonthAmount()
        val daysInMonth: Int = repository.getDaysInMonth()
        return@withContext monthAmount / daysInMonth
    }
}