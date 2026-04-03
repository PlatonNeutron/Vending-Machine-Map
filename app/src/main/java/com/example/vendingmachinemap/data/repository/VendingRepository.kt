package com.example.vendingmachinemap.data.repository

import com.example.vendingmachinemap.data.model.VendingMachine
import com.google.android.gms.maps.model.LatLng

object VendingRepository {
    private val _machines = mutableListOf(
        VendingMachine("2", LatLng(48.4068, -71.0575), "Distributeur Place du Royaume", "Boissons"),
        VendingMachine("3",LatLng(48.4245, -71.0592), "Distributeur Cégep", "Café chaud")
    )

    fun getNearbyVendingMachines(): List<VendingMachine> = _machines

    fun addVendingMachine(machine: VendingMachine) {
        _machines.add(machine)
    }
}