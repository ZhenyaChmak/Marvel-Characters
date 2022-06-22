package com.example.marvelcharacters.adapter.character

import androidx.recyclerview.widget.RecyclerView
import com.example.marvelcharacters.databinding.FragmentCharacterBinding
import com.example.marvelcharacters.domain.model.Character
import com.squareup.picasso.Picasso

class CharacterViewHolder(
    private val binding: FragmentCharacterBinding,
    private val onClickedCharacter: (Character) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(character: Character) {
        with(binding) {

            characterName.text = character.name

            Picasso.with(root.context).load(character.photo).into(itemCharacterPhoto)

            details.setOnClickListener {
                onClickedCharacter(character)
            }

        }
    }
}