package com.example.edit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.edit.databinding.ActivityEditBinding
import com.example.edit.di.*
import com.example.edit.ui.EditFragment
import com.example.utils.navigation.NavigationFactoryEnum.EDIT
import com.example.utils.navigation.navigationFactory

class EditActivity : AppCompatActivity() {

    private val navigationFactory by navigationFactory()

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
        val navigation: EditNavigation = navigationFactory.getNavigation(EDIT)
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