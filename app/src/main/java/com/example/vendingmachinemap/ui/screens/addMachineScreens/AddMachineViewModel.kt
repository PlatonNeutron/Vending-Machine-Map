package com.example.vendingmachinemap.ui.screens.addMachineScreens

import android.annotation.SuppressLint
import android.content.Context
import android.location.Geocoder
import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.vendingmachinemap.data.model.VendingMachine
import com.example.vendingmachinemap.data.repository.VendingRepository
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import java.util.*

const val DEFAULT_POSITION_TEXT = "Recherche de votre position..."

class AddMachineViewModel : ViewModel() {
    var address by mutableStateOf(DEFAULT_POSITION_TEXT)
    var comment by mutableStateOf("")
    var rating by mutableStateOf(3)
    var currentLatLng by mutableStateOf<LatLng?>(null)

    // From llm
    @SuppressLint("MissingPermission")
    fun fetchCurrentLocation(context: Context) {
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            location?.let {
                val latLng = LatLng(it.latitude, it.longitude)
                currentLatLng = latLng
                // Convertir les coordonnées en adresse lisible
                val geocoder = Geocoder(context, Locale.getDefault())
                val addresses = geocoder.getFromLocation(it.latitude, it.longitude, 1)
                address = addresses?.firstOrNull()?.getAddressLine(0) ?: "Adresse inconnue"
            }
        }
    }

    fun saveMachine(onSuccess: () -> Unit) {
                val latLng = currentLatLng ?: return
        val newMachine = VendingMachine(
            id = UUID.randomUUID().toString(),
            name = address,
            position = latLng,
            description = comment
        )
        VendingRepository.addVendingMachine(newMachine)
        onSuccess()
    }


}