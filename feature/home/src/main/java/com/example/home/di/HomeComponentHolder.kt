package com.example.home.di

private var _component: HomeComponent? = null
val component: HomeComponent get() = requireNotNull(_component) { "Need to initialize first." }

fun setComponent(component: HomeComponent) {
    _component = component
}

fun clearComponent() {
    _component = null
}