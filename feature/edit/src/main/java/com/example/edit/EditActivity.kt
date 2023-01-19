package com.example.edit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.edit.databinding.ActivityEditBinding
import com.example.edit.di.*
import com.example.edit.ui.EditFragment

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        initDaggerComponent()
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                binding.flContainer.id,
                EditFragment()
            )
        }
    }

    private fun initDaggerComponent() {
        val navigation: EditNavigation = application as EditNavigation
        val component: EditComponent = DaggerEditComponent.builder()
            .editModule(EditModule(navigation))
            .build()
        setComponent(component)
    }

    override fun onDestroy() {
        clearComponent()
        super.onDestroy()
    }
}