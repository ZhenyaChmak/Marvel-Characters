package com.example.marvelcharacters.adapter.character

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.marvelcharacters.databinding.FragmentCharacterBinding
import com.example.marvelcharacters.domain.model.Character

class CharacterAdapter(
    context: Context,
    private val onClickedCharacter: (Character) -> Unit
) : ListAdapter<Character, CharacterViewHolder>(DIFF_UTIL) {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            binding = FragmentCharacterBinding.inflate(layoutInflater, parent, false),
            onClickedCharacter = onClickedCharacter
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {

        private val DIFF_UTIL = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(
                oldItem: Character,
                newItem: Character
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: Character,
                newItem: Character
            ): Boolean {
                /*  val oldUser = oldItem as? PageItem.Element
                  val newUser = newItem as? PageItem.Element
                  return oldUser?.data == newUser?.data*/
                return oldItem == newItem
            }
        }
    }
}