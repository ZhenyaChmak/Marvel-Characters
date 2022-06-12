package com.example.marvelcharacters.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelcharacters.adapter.CharacterAdapter
import com.example.marvelcharacters.databinding.FragmentDetailsCharacterBinding
import com.example.marvelcharacters.databinding.FragmentListCharactersBinding
import com.example.marvelcharacters.domain.model.Character

class CharacterDetails : Fragment() {

    private var _binding: FragmentDetailsCharacterBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return FragmentDetailsCharacterBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}