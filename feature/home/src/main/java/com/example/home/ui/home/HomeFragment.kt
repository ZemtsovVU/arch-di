package com.example.home.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.home.HomeNavigation
import com.example.home.R
import com.example.home.databinding.FragmentHomeBinding
import com.example.home.di.component
import kotlinx.coroutines.launch

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels { component.provideViewModelFactory() }
    private val navigation: HomeNavigation = component.provideNavigation()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        // todo fix id providing
        binding.bExpenses.setOnClickListener {
            navigation.openExpenses(requireActivity(), viewModel.dayAmount) { correctedDayAmount ->
                viewModel.setCorrectedDayAmount(correctedDayAmount)
                binding.tvDayAmount.text = correctedDayAmount.toString()
            }
        }
        binding.bEdit.setOnClickListener { navigation.openEditScreen(requireActivity()) }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    binding.tvDayAmount.text = it.dayAmount.toString()
                }
            }
        }
    }
}