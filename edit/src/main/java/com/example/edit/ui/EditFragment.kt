package com.example.edit.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.edit.R
import com.example.edit.databinding.FragmentEditBinding
import com.example.edit.di.EditViewModelFactory
import kotlinx.coroutines.launch

class EditFragment : Fragment(R.layout.fragment_edit) {

    private lateinit var binding: FragmentEditBinding

    private val viewModel: EditViewModel by viewModels { checkNotNull(viewModelFactory) }
    var viewModelFactory: EditViewModelFactory? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEditBinding.bind(view)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {

                }
            }
        }
    }
}