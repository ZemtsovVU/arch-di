package com.example.utils.navigation

import androidx.fragment.app.FragmentActivity
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun navigationFactory(): ReadOnlyProperty<FragmentActivity, NavigationFactory> =
    NavigationFactoryDelegate()

private class NavigationFactoryDelegate : ReadOnlyProperty<FragmentActivity, NavigationFactory> {
    override fun getValue(thisRef: FragmentActivity, property: KProperty<*>): NavigationFactory {
        return thisRef.application as NavigationFactory
    }
}