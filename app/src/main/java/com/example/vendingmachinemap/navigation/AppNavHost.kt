package com.example.vendingmachinemap.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.vendingmachinemap.ui.screens.AccountScreen
import com.example.vendingmachinemap.ui.screens.MapScreen

@Composable
fun AppNavHost(navController: NavHostController, startDestination: Destinations, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = startDestination.route) {
        composable(route = Destinations.Map.route) {
            MapScreen()
        }
        composable(route = Destinations.Account.route) {
            AccountScreen()
        }
    }
}