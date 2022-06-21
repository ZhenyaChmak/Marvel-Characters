package com.example.marvelcharacters.ui.map

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.marvelcharacters.R
import com.example.marvelcharacters.databinding.FragmentGoogleMapDetailsCountryBinding
import com.example.marvelcharacters.model.map.DetailsCountryViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailsCountry : Fragment() {
    private var _binding: FragmentGoogleMapDetailsCountryBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val args by navArgs<DetailsCountryArgs>()
    private val viewModelDetails by viewModel<DetailsCountryViewModel> {
        parametersOf(args.countryName)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentGoogleMapDetailsCountryBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelDetails
            .dataFlow
            .onEach {
                it.fold(
                    onSuccess = { listCountry ->
                        listCountry.map { country ->
                            with(binding) {
                                flag.load(country.flag)
                                nameCountry.text = country.name
                                regionDetails.text = country.region
                                capitalDetails.text = country.capital
                                timezoneDetails.text = country.timezones
                            }
                        }
                    },
                    onFailure = {
                        AlertDialog.Builder(requireContext())
                            .setMessage(R.string.failure)
                            .setCancelable(false)
                            .setPositiveButton(R.string.ok) { _, _ -> findNavController().navigateUp() }
                            .show()
                    }
                )
            }.launchIn(viewLifecycleOwner.lifecycleScope)

        binding.fromMap.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}