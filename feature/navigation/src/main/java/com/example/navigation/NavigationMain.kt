package com.example.navigation

object NavigationMain {

    private var _navFacade: NavigationFacade? = null
    val navFacade: NavigationFacade
        get() = requireNotNull(_navFacade) { "Need initialize first" }

    fun initialize(navFacade: NavigationFacade) {
        _navFacade = navFacade
    }

    fun release() {
        _navFacade = null
    }
}