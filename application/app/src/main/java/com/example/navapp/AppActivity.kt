package com.example.navapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.app.databinding.ActivityAppBinding
import com.example.home.HomeFlowFragment
import com.example.navapp.navigation.EditNavigator
import com.example.navapp.navigation.HomeNavigator
import com.example.utils.navigation.NavigationFactory
import com.example.utils.navigation.NavigationFactoryEnum

class AppActivity : AppCompatActivity(), NavigationFactory {

    private lateinit var binding: ActivityAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                binding.flContainer.id,
                HomeFlowFragment()
            )
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T> getNavigation(enum: NavigationFactoryEnum): T {
        return when (enum) {
            NavigationFactoryEnum.HOME -> HomeNavigator(this) as T
            NavigationFactoryEnum.EDIT -> EditNavigator() as T
        }
    }
}