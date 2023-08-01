package com.example.home

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.home.databinding.FragmentHomeFlowBinding
import com.example.home.di.DaggerHomeComponent
import com.example.home.di.HomeComponent
import com.example.home.di.HomeModule
import com.example.home.di.clearComponent
import com.example.home.di.setComponent
import com.example.home.ui.HomeCompletionReason
import com.example.home.ui.home.HomeFragment
import com.example.utils.navigation.Navigation
import com.example.utils.navigation.NavigationFactoryEnum
import com.example.utils.navigation.activityNavigationFactory

class HomeFlowFragment : Fragment(R.layout.fragment_home_flow) {

    private val navigationFactory by activityNavigationFactory()

    private var _binding: FragmentHomeFlowBinding? = null
    private val binding: FragmentHomeFlowBinding get() = checkNotNull(_binding)

    override fun onAttach(context: Context) {
        initDaggerComponent()
        super.onAttach(context)
    }

    private fun initDaggerComponent() {
        val navigation: Navigation<HomeCompletionReason> = navigationFactory.getNavigation(
            NavigationFactoryEnum.HOME
        )
        val component: HomeComponent = DaggerHomeComponent.builder()
            .homeModule(HomeModule(navigation))
            .build()
        setComponent(component)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeFlowBinding.bind(view)

        childFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                binding.flContainer.id,
                HomeFragment()
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDetach() {
        clearComponent()
        super.onDetach()
    }
}