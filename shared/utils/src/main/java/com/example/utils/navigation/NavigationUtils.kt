package com.example.utils.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

// Application
fun navigationFactory(): ReadOnlyProperty<FragmentActivity, NavigationFactory> =
    NavigationFactoryDelegate()

private class NavigationFactoryDelegate : ReadOnlyProperty<FragmentActivity, NavigationFactory> {
    override fun getValue(thisRef: FragmentActivity, property: KProperty<*>): NavigationFactory {
        return thisRef.application as NavigationFactory
    }
}

//Activity
fun activityNavigationFactory(): ReadOnlyProperty<Fragment, NavigationFactory> =
    ActivityNavigationFactoryDelegate()

private class ActivityNavigationFactoryDelegate : ReadOnlyProperty<Fragment, NavigationFactory> {
    override fun getValue(thisRef: Fragment, property: KProperty<*>): NavigationFactory {
        return thisRef.requireActivity() as NavigationFactory
    }
}