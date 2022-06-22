package com.example.marvelcharacters.adapter.character

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelcharacters.adapter.LoadingViewHolder
import com.example.marvelcharacters.databinding.FragmentCharacterBinding
import com.example.marvelcharacters.databinding.LoadingBinding
import com.example.marvelcharacters.domain.model.Character
import com.example.marvelcharacters.model.PageItem

class CharacterAdapter(
    context: Context,
    private val onClickedCharacter: (Character) -> Unit
) : ListAdapter<PageItem<Character>, RecyclerView.ViewHolder>(DIFF_UTIL) {

    private val layoutInflater = LayoutInflater.from(context)

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is PageItem.Element -> TYPE_CHARACTER
            PageItem.Loading -> TYPE_LOADING
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_CHARACTER -> {
                CharacterViewHolder(
                    binding = FragmentCharacterBinding.inflate(layoutInflater, parent, false),
                    onClickedCharacter = onClickedCharacter
                )
            }

            TYPE_LOADING -> {
                LoadingViewHolder(
                    binding = LoadingBinding.inflate(layoutInflater, parent, false)
                )
            }
            else -> error("Error - $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val characterLoadingVH = holder as? CharacterViewHolder ?: return
        val item = (getItem(position) as? PageItem.Element<Character>)?.data ?: return
        characterLoadingVH.bind(item)
    }

    companion object {

        private const val TYPE_CHARACTER = 0
        private const val TYPE_LOADING = 1

        private val DIFF_UTIL = object : DiffUtil.ItemCallback<PageItem<Character>>() {
            override fun areItemsTheSame(
                oldItem: PageItem<Character>,
                newItem: PageItem<Character>
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: PageItem<Character>,
                newItem: PageItem<Character>
            ): Boolean {
                val oldUser = oldItem as? PageItem.Element
                val newUser = newItem as? PageItem.Element
                return oldUser?.data == newUser?.data
            }
        }
    }

}