package com.example.edit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.edit.databinding.ActivityEditBinding
import com.example.edit.di.DaggerEditComponent
import com.example.edit.di.clearComponent
import com.example.edit.di.setComponent
import com.example.edit.ui.EditFragment

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setComponent(DaggerEditComponent.create())
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

    override fun onDestroy() {
        clearComponent()
        super.onDestroy()
    }
}