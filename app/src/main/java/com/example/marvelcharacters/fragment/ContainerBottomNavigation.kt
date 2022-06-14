package com.example.marvelcharacters.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.marvelcharacters.R
import com.example.marvelcharacters.databinding.FragmentContainerBottomNavigationBinding

class ContainerBottomNavigation : Fragment() {

    private var _binding: FragmentContainerBottomNavigationBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentContainerBottomNavigationBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuController =
            (childFragmentManager.findFragmentById(R.id.fragment_container_bottom_navigation) as NavHostFragment)
                .navController
        binding.bottomNavigation.setupWithNavController(menuController)

        menuController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.character_details -> binding.bottomNavigation.visibility = View.GONE
                R.id.characters_list -> binding.bottomNavigation.visibility = View.VISIBLE
                else -> binding.bottomNavigation.visibility = View.VISIBLE
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}