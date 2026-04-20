package com.example.vendingmachinemap.ui.screens.homeScreens

import androidx.lifecycle.ViewModel
import com.example.vendingmachinemap.model.data.model.VendingMachine
import com.example.vendingmachinemap.data.repository.VendingRepository
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {

    // Default location = Chicoutimi
    val defaultLocation = LatLng(48.4284, -71.0761)

    private val _vendingMachines = MutableStateFlow<List<VendingMachine>>(emptyList())
    val vendingMachines: StateFlow<List<VendingMachine>> = _vendingMachines

    init {
        loadVendingMachines()
    }

    private fun loadVendingMachines() {
        _vendingMachines.value = VendingRepository.getNearbyVendingMachines()
    }
}