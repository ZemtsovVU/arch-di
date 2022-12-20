package com.example.storageimpl

import com.example.storageapi.BudgetStorage


class FakeBudgetStorage : BudgetStorage {

    override fun getMonthAmount(): Int {
        return 40_000
    }

    override fun getDaysInMonth(): Int {
        return 30
    }
}