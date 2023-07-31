package com.example.home.ui.home

sealed class HomeCompletionReason {

    // todo rename

    class OpenExpenses(val dayAmount: Int) : HomeCompletionReason()

    object OpenEditScreen : HomeCompletionReason()
}
