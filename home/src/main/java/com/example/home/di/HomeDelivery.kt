package com.example.home.di

import com.example.utils.ModuleLifecycle

object HomeDelivery {
    var lifecycle: ModuleLifecycle? = null
    var factory: HomeFactory? = null
}