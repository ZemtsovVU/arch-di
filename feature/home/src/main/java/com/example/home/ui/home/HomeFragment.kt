package com.example.home.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.home.R
import com.example.home.databinding.FragmentHomeBinding
import com.example.home.di.component
import com.example.home.ui.HomeCompletionReason
import com.example.utils.navigation.Navigation
import kotlinx.coroutines.launch

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = checkNotNull(_binding)

    private val viewModel: HomeViewModel by viewModels { component.provideViewModelFactory() }
    private val navigation: Navigation<HomeCompletionReason> = component.provideNavigation()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("aaaa HomeFragment onViewCreated() ${hashCode()}")
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        // todo fix id providing
        binding.bExpenses.setOnClickListener {
            navigation.onComplete(OpenExpenses(viewModel.dayAmount)) {
                val correctedDayAmount = it.getInt("b")
                viewModel.setCorrectedDayAmount(correctedDayAmount)
            }
        }
        binding.bEdit.setOnClickListener {
            navigation.onComplete(OpenEditScreen)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    binding.tvDayAmount.text = it.dayAmount.toString()
                }
            }
        }
    }

    override fun onDestroyView() {
        println("aaaa HomeFragment onDestroyView() ${hashCode()}")
        super.onDestroyView()
        _binding = null
    }
}