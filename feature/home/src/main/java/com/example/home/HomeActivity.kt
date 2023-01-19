package com.example.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.home.databinding.ActivityHomeBinding
import com.example.home.di.*
import com.example.home.ui.HomeFragment
import com.example.utils.navigation.NavigationFactoryEnum.HOME
import com.example.utils.navigation.navigationFactory

class HomeActivity : AppCompatActivity() {

    private val navigationFactory by navigationFactory()

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        initDaggerComponent()
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                binding.flContainer.id,
                HomeFragment()
            )
        }
    }

    private fun initDaggerComponent() {
        val navigation: HomeNavigation = navigationFactory.getNavigation(HOME)
        val component: HomeComponent = DaggerHomeComponent.builder()
            .homeModule(HomeModule(navigation))
            .build()
        setComponent(component)
    }

    override fun onDestroy() {
        clearComponent()
        super.onDestroy()
    }
}