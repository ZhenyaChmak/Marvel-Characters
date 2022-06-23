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
import androidx.navigation.fragment.findNavController
import com.example.marvelcharacters.R
import com.example.marvelcharacters.databinding.FragmentGoogleMapBinding
import com.example.marvelcharacters.model.map.MapViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class CustomGoogleMap : Fragment() {

    private var _binding: FragmentGoogleMapBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val viewModelMap by viewModel<MapViewModel>()

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

            remoteGoogleMap.isMyLocationEnabled = checkLocationPermission()

            googleMap = remoteGoogleMap.apply {
                uiSettings.isZoomControlsEnabled = true
                uiSettings.isMyLocationButtonEnabled = true
                uiSettings.isCompassEnabled = true
            }

            viewModelMap
                .dataFlow
                .onEach {
                    it.fold(
                        onSuccess = { list ->
                            list.map { country ->

                                viewModelMap
                                    .toDetailsCountry(country)

                                googleMap?.customAddMarker(
                                    latitude = country.latitude,
                                    longitude = country.longitude,
                                    title = country.name
                                )

                                googleMap?.customAnimateCamera(
                                    latitude = country.latitude,
                                    longitude = country.longitude,
                                    CAMERA_ZOOM
                                )
                            }
                        },
                        onFailure = {
                            AlertDialog.Builder(requireContext())
                                .setMessage(R.string.failure)
                                .setCancelable(false)
                                .setPositiveButton(R.string.ok) { _, _ -> findNavController().navigateUp() }
                                .show()
                        }
                    )
                }.launchIn(viewLifecycleOwner.lifecycleScope)

            googleMap?.setOnMarkerClickListener { _ ->
                viewModelMap
                    .nextDetailsCountry
                    .onEach {
                        findNavController().navigate(
                            CustomGoogleMapDirections.toDetailsCountry(it.name)
                        )
                    }
                    .launchIn(viewLifecycleOwner.lifecycleScope)
                false
            }
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

    companion object {
        private const val CAMERA_ZOOM = 5.0f
    }

}

private fun GoogleMap.customAnimateCamera(
    latitude: Double,
    longitude: Double,
    cameraZoom: Float
) = animateCamera(
    CameraUpdateFactory.newCameraPosition(
        CameraPosition.fromLatLngZoom(
            LatLng(
                latitude,
                longitude
            ), cameraZoom
        )
    )
)

private fun GoogleMap.customAddMarker(
    latitude: Double,
    longitude: Double,
    title: String
) = addMarker(
    MarkerOptions()
        .title(title)
        .position(
            LatLng(latitude, longitude)
        )
)