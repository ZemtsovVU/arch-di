package com.example.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.home.databinding.ActivityHomeBinding
import com.example.home.di.*
import com.example.home.ui.HomeFragment
import com.example.utils.navigation.NavigationFactory
import com.example.utils.navigation.NavigationFactoryEnum.HOME

class HomeActivity : AppCompatActivity() {

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
        val navigation: HomeNavigation = (application as NavigationFactory).getNavigation(HOME)
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