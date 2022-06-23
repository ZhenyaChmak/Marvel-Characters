package com.example.marvelcharacters.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import coil.load
import com.example.marvelcharacters.databinding.FragmentCharacterSeriesDetailsBinding

class CustomDialogFragment : DialogFragment() {

    private var _binding: FragmentCharacterSeriesDetailsBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentCharacterSeriesDetailsBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val _arguments = arguments
        if (_arguments != null) {
            binding.nameSeriesDetails.text = _arguments.getString("name")
            binding.photoSeriesDetails.load(_arguments.getString("photo"))
            binding.descriptionSeriesDetails.text = _arguments.getString("description")
        }

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}