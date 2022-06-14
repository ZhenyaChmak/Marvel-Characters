package com.example.marvelcharacters.adapter.character

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.marvelcharacters.databinding.FragmentCharacterBinding
import com.example.marvelcharacters.domain.model.Character

class CharacterViewHolder(
    private val binding: FragmentCharacterBinding,
    private val onClickedCharacter: (Character) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(character: Character) {
        with(binding) {
            userName.text = character.name
            itemCharacterPhoto.load(character.photo)

            details.setOnClickListener {
                onClickedCharacter(character)
            }
        }
    }
}