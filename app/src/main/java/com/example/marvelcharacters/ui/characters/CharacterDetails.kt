package com.example.marvelcharacters.ui.characters

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.marvelcharacters.R
import com.example.marvelcharacters.adapter.comics.ComicsAdapter
import com.example.marvelcharacters.adapter.events.EventsAdapter
import com.example.marvelcharacters.adapter.series.SeriesAdapter
import com.example.marvelcharacters.databinding.FragmentCharacterDetailsBinding
import com.example.marvelcharacters.model.comics.ComicsListViewModel
import com.example.marvelcharacters.model.detais.SeriesListViewModel
import com.example.marvelcharacters.model.events.EventsListViewModel
import com.example.marvelcharacters.ui.showDetailsComics
import com.example.marvelcharacters.ui.showDetailsEvents
import com.example.marvelcharacters.ui.showDetailsSeries
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CharacterDetails : Fragment() {

    private var _binding: FragmentCharacterDetailsBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val args by navArgs<CharacterDetailsArgs>()

    private val viewModelSeries by viewModel<SeriesListViewModel> {
        parametersOf(args.characterId)
    }
    private val viewModelComics by viewModel<ComicsListViewModel> {
        parametersOf(args.characterId)
    }
    private val viewModelEvents by viewModel<EventsListViewModel> {
        parametersOf(args.characterId)
    }

    private val adapterSeries by lazy {
        SeriesAdapter(requireContext()) { series ->
            showDetailsSeries(series).show(childFragmentManager, "series")
        }
    }

    private val adapterComics by lazy {
        ComicsAdapter(requireContext()) { comics ->
            showDetailsComics(comics).show(childFragmentManager, "comics")
        }
    }

    private val adapterEvents by lazy {
        EventsAdapter(requireContext()) { events ->
            showDetailsEvents(events).show(childFragmentManager, "events")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return FragmentCharacterDetailsBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.seriesList.adapter = adapterSeries
        binding.seriesList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.comicsList.adapter = adapterComics
        binding.comicsList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)


        binding.storiesList.adapter = adapterEvents
        binding.storiesList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.fromDetails.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.itemCharacterDetailPhoto.load(args.characterPhoto)
        binding.characterNameDetails.text = args.characterName

        viewModelSeries
            .dataFlow
            .onEach {
                it.fold(
                    onSuccess = { series ->
                        adapterSeries.submitList(series)
                    },
                    onFailure = {
                        AlertDialog.Builder(requireContext())
                            .setMessage(R.string.failure)
                            .show()
                    }
                )
            }.launchIn(viewLifecycleOwner.lifecycleScope)


        viewModelComics
            .dataFlow
            .onEach {
                it.fold(
                    onSuccess = { comics ->
                        adapterComics.submitList(comics)
                    },
                    onFailure = {
                        AlertDialog.Builder(requireContext())
                            .setMessage(R.string.failure)
                            .show()
                    }
                )
            }.launchIn(viewLifecycleOwner.lifecycleScope)

        viewModelEvents
            .dataFlow
            .onEach {
                it.fold(
                    onSuccess = { events ->
                        adapterEvents.submitList(events)
                    },
                    onFailure = {
                        AlertDialog.Builder(requireContext())
                            .setMessage(R.string.failure)
                            .show()
                    }
                )
            }.launchIn(viewLifecycleOwner.lifecycleScope)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
