package com.example.edit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.edit.databinding.ActivityEditBinding
import com.example.edit.di.EditDelivery
import com.example.edit.di.EditFactory
import com.example.edit.ui.EditFragment
import com.example.utils.ModuleLifecycle

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding

    private val lifecycle: ModuleLifecycle
        get() = checkNotNull(EditDelivery.lifecycle)
    private val factory: EditFactory
        get() = checkNotNull(EditDelivery.factory)

    override fun onCreate(savedInstanceState: Bundle?) {
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
}