package com.example.marvelcharacters.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.marvelcharacters.databinding.FragmentCharacterBinding
import com.example.marvelcharacters.domain.model.Character

class CharacterViewHolder(
    private val binding: FragmentCharacterBinding,
    private val onClickedCharacter: (Character) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(character: Character) {
        with(binding) {
            userName.text = character.name

            root.setOnClickListener {
                onClickedCharacter(character)
            }
        }
    }
}