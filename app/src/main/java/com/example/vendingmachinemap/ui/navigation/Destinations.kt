package com.example.vendingmachinemap.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.ui.graphics.vector.ImageVector

// Liste des destinations
enum class Destinations(val label: String, val route: String, val icon: ImageVector) {
    Map("Map", "map_screen", Icons.Default.LocationOn),
    Account("Account", "account_screen", Icons.Default.AccountCircle),
}