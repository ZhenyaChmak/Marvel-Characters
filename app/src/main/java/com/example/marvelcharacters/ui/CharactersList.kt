package com.example.marvelcharacters.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.marvelcharacters.adapter.character.CharacterAdapter
import com.example.marvelcharacters.databinding.FragmentCharactersListBinding
import com.example.marvelcharacters.model.CharacterListViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersList : Fragment() {

    private var _binding: FragmentCharactersListBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val viewModel by viewModel<CharacterListViewModel>()

    private val adapter by lazy {
        CharacterAdapter(requireContext()) {
            findNavController().navigate(
                CharactersListDirections.toCharacterDetails(
                    it.id, it.name, it.photo
                )
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return FragmentCharactersListBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.charactersListContainer.adapter = adapter

        scrollView(binding.charactersListContainer, adapter)

        viewModel
            .dataFlow
            .onEach {
                it.fold(
                    onSuccess = {
                        println()
                        adapter.submitList(it)
                    },
                    onFailure = {
                        println(it)
                    }
                )
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

