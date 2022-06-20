package com.example.marvelcharacters.ui.map

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.marvelcharacters.databinding.FragmentGoogleMapBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.android.ext.android.inject

class CustomGoogleMap : Fragment() {
    private var _binding: FragmentGoogleMapBinding? = null
    private val binding get() = requireNotNull(_binding)

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


            googleMap?.addMarker(
                MarkerOptions()
                    .title("dddddddddd")
                    .position(
                        LatLng(48.4357, 28.9165)
                    )
            )
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