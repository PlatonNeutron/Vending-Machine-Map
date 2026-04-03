package com.example.vendingmachinemap.data.model

import com.google.android.gms.maps.model.LatLng

data class VendingMachine(
    val id: String,

    val position: LatLng,

    val name: String,
    val description: String
)