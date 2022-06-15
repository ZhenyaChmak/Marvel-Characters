package com.example.marvelcharacters.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelcharacters.adapter.character.CharacterAdapter
import com.example.marvelcharacters.adapter.series.SeriesAdapter
import com.example.marvelcharacters.databinding.FragmentDetailsCharacterBinding
import com.example.marvelcharacters.model.SeriesListViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CharacterDetails : Fragment() {

    private var _binding: FragmentDetailsCharacterBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val args by navArgs<CharacterDetailsArgs>()
    private val viewModelSeries by viewModel<SeriesListViewModel>() {
        parametersOf(args.characterId)
    }
    private val adapterSeries by lazy {
        SeriesAdapter(requireContext()) {

        }
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return FragmentDetailsCharacterBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.seriesList.adapter = adapterSeries
        binding.seriesList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)


        viewModelSeries
            .dataFlow
            .onEach {
                it.fold(
                    onSuccess = {
                        println()
                         adapterSeries.submitList(it)
                    },
                    onFailure = {
                        println(it)
                    }
                )
            }.launchIn(viewLifecycleOwner.lifecycleScope)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}