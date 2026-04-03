package com.example.vendingmachinemap.ui.screens.addMachineScreens

import android.annotation.SuppressLint
import android.content.Context
import android.location.Geocoder
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.vendingmachinemap.data.model.VendingMachine
import com.example.vendingmachinemap.data.repository.VendingRepository
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import java.util.*

const val DEFAULT_POSITION_TEXT = "Recherche de votre position..."

class AddMachineViewModel : ViewModel() {
    var name by mutableStateOf("")
    var description by mutableStateOf("")
    var address by mutableStateOf(DEFAULT_POSITION_TEXT)
    var rating by mutableStateOf(3)
    var currentLatLng by mutableStateOf<LatLng?>(null)

    // From Gemini LLM
    @SuppressLint("MissingPermission")
    fun fetchCurrentLocation(context: Context) {
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            location?.let {
                val latLng = LatLng(it.latitude, it.longitude)
                currentLatLng = latLng
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
            name = name.ifBlank { "Distributeur sans nom" },
            position = latLng,
            description = description
        )
        VendingRepository.addVendingMachine(newMachine)
        onSuccess()
    }
}