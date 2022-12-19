package com.example.utils

@RequiresOptIn(message = "Delivery object can only be used in app module and in Activity class of feature-modules.")
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS)
annotation class DeliveryGuard()
