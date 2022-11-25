package com.example.edit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.edit.databinding.ActivityEditBinding
import com.example.edit.di.EditFactory
import com.example.edit.ui.EditFragment
import com.example.utils.DeliveryGuard
import com.example.utils.ModuleLifecycle

@OptIn(DeliveryGuard::class)
class EditActivity : AppCompatActivity() {

    companion object {
        const val LIFECYCLE_EXTRA_KEY = "EDIT_LIFECYCLE"
        const val FACTORY_EXTRA_KEY = "EDIT_FACTORY"
    }

    private lateinit var binding: ActivityEditBinding

    private lateinit var lifecycle: ModuleLifecycle
    private lateinit var factory: EditFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        initExtras()
        lifecycle.onStarted()
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                binding.flContainer.id,
                EditFragment().apply {
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

    private fun initExtras() {
        val extras = checkNotNull(intent.extras)
        lifecycle = extras.getSerializable(LIFECYCLE_EXTRA_KEY) as ModuleLifecycle
        factory = extras.getSerializable(FACTORY_EXTRA_KEY) as EditFactory
    }
}