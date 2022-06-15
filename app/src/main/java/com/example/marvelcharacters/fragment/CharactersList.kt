package com.example.marvelcharacters.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelcharacters.adapter.character.CharacterAdapter
import com.example.marvelcharacters.databinding.FragmentListCharactersBinding
import com.example.marvelcharacters.model.CharacterListViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersList : Fragment() {

    private var _binding: FragmentListCharactersBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val viewModel by viewModel<CharacterListViewModel>()

    private val adapter by lazy {
        CharacterAdapter(requireContext()) {
            findNavController().navigate(
                CharactersListDirections.toCharacterDetails(
                    it.id, it.name
                )
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return FragmentListCharactersBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.charactersListContainer.adapter = adapter
        /*binding.charactersListContainer.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)*/

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