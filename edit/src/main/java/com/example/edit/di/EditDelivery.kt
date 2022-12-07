package com.example.edit.di

import com.example.utils.DeliveryGuard
import com.example.utils.ModuleLifecycle

@DeliveryGuard
object EditDelivery {
    var lifecycle: ModuleLifecycle? = null
    var factory: EditFactory? = null
}