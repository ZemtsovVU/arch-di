package com.example.home.ui.expenses

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.home.HomeNavigation
import com.example.home.R
import com.example.home.databinding.FragmentExpensesBinding
import com.example.home.di.component
import kotlinx.coroutines.launch

class ExpensesFragment : Fragment(R.layout.fragment_expenses) {

    private lateinit var binding: FragmentExpensesBinding

    private val viewModel: ExpensesViewModel by viewModels()
    private val navigation: HomeNavigation = component.provideNavigation()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentExpensesBinding.bind(view)

        binding.bSave.setOnClickListener { viewModel.onSaveButtonClicked() }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    if (it.isSaved) {
                        // todo fix id providing
                        navigation.expensesSaved(parentFragmentManager, R.id.flContainer)
                    }
                }
            }
        }
    }
}