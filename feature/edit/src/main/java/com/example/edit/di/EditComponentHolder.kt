package com.example.edit.di

private var _component: EditComponent? = null
val component: EditComponent get() = requireNotNull(_component) { "Need to initialize first." }

fun setComponent(component: EditComponent) {
    _component = component
}

fun clearComponent() {
    _component = null
}