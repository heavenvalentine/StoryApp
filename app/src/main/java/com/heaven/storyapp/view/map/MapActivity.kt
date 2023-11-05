package com.heaven.storyapp.view.map

import android.content.pm.PackageManager
import android.content.res.Resources
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import com.heaven.storyapp.R
import com.heaven.storyapp.databinding.ActivityMapBinding
import com.heaven.storyapp.view.ViewModelFactory
import com.heaven.storyapp.view.data.di.AlertIndicator

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapBinding

    private val mapViewModel by viewModels<MapViewModel> {
        ViewModelFactory.getInstance(this)
    }
    private var token: String ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        token = intent.getStringExtra(EXTRA_TOKEN)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isIndoorLevelPickerEnabled = true
        mMap.uiSettings.isCompassEnabled = true
        mMap.uiSettings.isMapToolbarEnabled = true

        getMyLocation()
        addManyMarkers(token.toString())
        setMapStyle()
    }

    private fun addManyMarkers(token: String) {
        mapViewModel.getStoriesWithLocation(token).observe(this@MapActivity){ alert ->
            if (alert != null){
                when(alert) {
                    is AlertIndicator.Error -> {
                        binding.progressBar.isVisible = false
                        Toast.makeText(this, alert.error, Toast.LENGTH_SHORT).show()
                    }
                    AlertIndicator.Loading -> {
                        binding.progressBar.isVisible = true
                    }
                    is AlertIndicator.Success -> {
                        binding.progressBar.isVisible = false
                        alert.data.listStory
                            .filter { it.lon != null && it.lat != null }
                            .forEach { data ->
                                val latLng = LatLng(data.lat!!, data.lon!!)
                                mMap.addMarker(
                                    MarkerOptions()
                                        .position(latLng)
                                        .title(data.name)
                                        .snippet(data.description)
                                )
                            }
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.map_options, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.normal_type -> {
                mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                true
            }
            R.id.satellite_type -> {
                mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
                true
            }
            R.id.terrain_type -> {
                mMap.mapType = GoogleMap.MAP_TYPE_TERRAIN
                true
            }
            R.id.hybrid_type -> {
                mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                getMyLocation()
            }
        }
    private fun getMyLocation() {
        if (ContextCompat.checkSelfPermission(
                this.applicationContext,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            mMap.isMyLocationEnabled = true
        } else {
            requestPermissionLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    private fun setMapStyle() {
        try {
            val success = mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.map_style))
            if (!success) {
                Toast.makeText(this, getString(R.string.style_parsing_failed), Toast.LENGTH_SHORT).show()
            }
        } catch (exception: Resources.NotFoundException) {
            Toast.makeText(this, "Can't find style. Error: ${exception.message}", Toast.LENGTH_SHORT).show()
        }
    }


    companion object {
        const val EXTRA_TOKEN: String = "extra_token"
    }
}