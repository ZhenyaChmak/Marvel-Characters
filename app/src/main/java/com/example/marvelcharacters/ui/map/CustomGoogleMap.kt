package com.example.marvelcharacters.ui.map

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.marvelcharacters.databinding.FragmentGoogleMapBinding
import com.example.marvelcharacters.model.map.MapViewModel
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CustomGoogleMap : Fragment() {

    private var _binding: FragmentGoogleMapBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val name = "Germany"

    private val viewModelMap by viewModel<MapViewModel> {
        parametersOf(name)
    }

    //  private val locationService by inject<LocationService>()
    private var googleMap: GoogleMap? = null

    @SuppressLint("MissingPermission")
    private val mapPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { permissionGranted ->
        if (permissionGranted) {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentGoogleMapBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        mapPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)

        binding.mapView.getMapAsync { remoteGoogleMap ->
            googleMap = remoteGoogleMap.apply {
                uiSettings.isZoomControlsEnabled = true
                uiSettings.isMyLocationButtonEnabled = true
            }

            remoteGoogleMap.isMyLocationEnabled = checkLocationPermission()


            viewModelMap
                .dataFlow
                .onEach {
                    println()
                    it.fold(
                        onSuccess = {
                            it.map {
                                googleMap?.addMarker(
                                    MarkerOptions()
                                        .title(it.name)
                                        .position(
                                            LatLng(52.52, 13.4)
                                        )
                                )
                            }
                        },
                        onFailure = {
                            AlertDialog.Builder(requireContext())
                                .setMessage("Failure")
                                .show()
                        }
                    )
                }.launchIn(viewLifecycleOwner.lifecycleScope)

        }

        binding.mapView.onCreate(savedInstanceState)


    }

    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.mapView.onDestroy()
        googleMap = null
        _binding = null
    }

    private fun checkLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

}