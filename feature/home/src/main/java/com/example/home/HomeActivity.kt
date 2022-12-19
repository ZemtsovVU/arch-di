package com.example.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.home.databinding.ActivityHomeBinding
import com.example.home.di.DaggerHomeComponent
import com.example.home.di.clearComponent
import com.example.home.di.setComponent
import com.example.home.ui.HomeFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setComponent(DaggerHomeComponent.create())
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

    override fun onDestroy() {
        clearComponent()
        super.onDestroy()
    }
}