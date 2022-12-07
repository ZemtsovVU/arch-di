package com.example.home.di

import com.example.utils.DeliveryGuard
import com.example.utils.ModuleLifecycle

@DeliveryGuard
object HomeDelivery {
    var lifecycle: ModuleLifecycle? = null
    var factory: HomeFactory? = null
}