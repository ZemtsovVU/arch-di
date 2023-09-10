package com.example.utils.navigation.observer

// todo можно оповещать только тех, кого нужно (map)
interface ResultObservable<K, V> {
    fun addObserver(resultObserver: ResultObserver<K, V>)
    fun removeObserver(resultObserver: ResultObserver<K, V>)
    fun notifyObservers(key: K, value: V)
}