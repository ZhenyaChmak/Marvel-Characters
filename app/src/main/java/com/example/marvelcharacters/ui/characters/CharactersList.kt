package com.example.marvelcharacters.ui.characters

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelcharacters.R
import com.example.marvelcharacters.adapter.character.CharacterAdapter
import com.example.marvelcharacters.databinding.FragmentCharactersListBinding
import com.example.marvelcharacters.model.CharacterListViewModel
import com.example.marvelcharacters.model.PageItem
import com.yarolegovich.discretescrollview.DiscreteScrollView
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersList : Fragment() {

    private var _binding: FragmentCharactersListBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val viewModel by viewModel<CharacterListViewModel>()

    private val adapter by lazy {
        CharacterAdapter(requireContext()) {
            viewModel
                .toCharacterDetails(it)
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
        scrollView(binding.charactersListContainer)

        viewModel
            .toCharacterDetails
            .onEach {
                findNavController().navigate(
                    CharactersListDirections.toCharacterDetails(
                        it.id, it.name, it.photo
                    )
                )
            }.launchIn(viewLifecycleOwner.lifecycleScope)


        binding.swipeRefresh.setOnRefreshListener {
            viewModel.onRefresh()
        }

        binding.charactersListContainer
            .addPaginationScrollListener(binding.charactersListContainer, ITEMS_TO_LOADING) {
                viewModel.onLoadMore()
            }

        viewModel
            .getData
            .onEach { list ->
                if (list.isEmpty()) {
                    AlertDialog.Builder(requireContext())
                        .setMessage(R.string.failure)
                        .setPositiveButton(R.string.ok){_,_ ->}
                        .show()
                } else {
                    adapter.submitList(
                        list.map {
                            PageItem.Element(it)
                        } + PageItem.Loading)

                    if (binding.swipeRefresh.isRefreshing) {
                        binding.swipeRefresh.isRefreshing = false
                    }
                }
            }.launchIn(viewLifecycleOwner.lifecycleScope)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ITEMS_TO_LOADING = 5
    }

}

fun RecyclerView.addPaginationScrollListener(
    view: DiscreteScrollView,
    itemsToLoading: Int,
    onLoadMore: () -> Unit
) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val totalItemCount = layoutManager?.itemCount
            val lastVisibility = view.currentItem

            if (totalItemCount != null) {
                if (totalItemCount <= (lastVisibility + itemsToLoading)) {
                    onLoadMore()
                }
            }
        }
    })
}