package com.example.utils.navigation.observer

interface ResultObserver<K, V> {
    fun onResult(key: K, value: V)
}