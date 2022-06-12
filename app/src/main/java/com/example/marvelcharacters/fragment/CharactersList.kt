package com.example.marvelcharacters.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelcharacters.adapter.CharacterAdapter
import com.example.marvelcharacters.databinding.FragmentListCharactersBinding
import com.example.marvelcharacters.domain.model.Character

class CharactersList : Fragment() {

    private var _binding: FragmentListCharactersBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val adapter by lazy {
        CharacterAdapter(requireContext()) {
            findNavController().navigate(
                CharactersListDirections.toCharacterDetails(it.name)
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return FragmentListCharactersBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.charactersList.adapter = adapter
        binding.charactersList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val a = List(10) {
            Character("$it")
        }
        adapter.submitList(a)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}