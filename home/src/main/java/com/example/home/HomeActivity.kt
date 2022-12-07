package com.example.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.home.databinding.ActivityHomeBinding
import com.example.home.di.HomeDelivery
import com.example.home.di.HomeFactory
import com.example.home.ui.HomeFragment
import com.example.utils.DeliveryGuard
import com.example.utils.ModuleLifecycle

@OptIn(DeliveryGuard::class)
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val lifecycle: ModuleLifecycle
        get() = checkNotNull(HomeDelivery.lifecycle)
    private val factory: HomeFactory
        get() = checkNotNull(HomeDelivery.factory)

    override fun onCreate(savedInstanceState: Bundle?) {
        lifecycle.onStarted()
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                binding.flContainer.id,
                HomeFragment().apply {
                    // При пересоздании фрагмента эти зависимости будут утеряны. Так делать нельзя.
                    // Здесь данный подход использован для наглядности в силу своей простоты.
                    viewModelFactory = factory.viewModelFactory
                    navigation = factory.navigation
                }
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.onFinished()
    }
}