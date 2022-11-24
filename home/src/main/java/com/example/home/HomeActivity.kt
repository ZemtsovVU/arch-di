package com.example.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.home.databinding.ActivityHomeBinding
import com.example.home.di.HomeDelivery
import com.example.home.di.HomeFactory
import com.example.home.di.HomeLifecycle
import com.example.home.ui.HomeFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val lifecycle: HomeLifecycle
        get() = checkNotNull(HomeDelivery.lifecycle)
    private val factory: HomeFactory
        get() = checkNotNull(HomeDelivery.factory)

    override fun onCreate(savedInstanceState: Bundle?) {
        lifecycle.onCreated()
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                binding.flContainer.id,
                HomeFragment().apply {
                    viewModelFactory = factory.viewModelFactory
                }
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.onDestroyed()
    }
}