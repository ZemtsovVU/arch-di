package com.example.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.navigation.HomeNavigator
import com.example.utils.navigation.NavigationFactory
import com.example.utils.navigation.NavigationFactoryEnum
import com.example.utils.navigation.NavigationFactoryEnum.EDIT
import com.example.utils.navigation.NavigationFactoryEnum.HOME

class DemoActivity : AppCompatActivity(), NavigationFactory {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // todo
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T> getNavigation(enum: NavigationFactoryEnum): T {
        return when (enum) {
            HOME -> HomeNavigator(this) as T
            EDIT -> error("Not supported screen in Demo app.")
        }
    }
}