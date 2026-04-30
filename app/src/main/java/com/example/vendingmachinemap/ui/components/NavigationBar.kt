package com.example.vendingmachinemap.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.vendingmachinemap.model.data.dao.UsersDAO
import com.example.vendingmachinemap.ui.navigation.AppNavHost
import com.example.vendingmachinemap.ui.navigation.Destinations

// Creation of the NavBar
@Composable
fun NavigationBar(userDao: UsersDAO) {
    val navController = rememberNavController()
    val startDestination = Destinations.Map
    var selectedDestination by rememberSaveable { mutableIntStateOf(startDestination.ordinal) }

    Scaffold(
        //modifier = modifier,
        bottomBar = {
            NavigationBar(windowInsets = NavigationBarDefaults.windowInsets) {
                Destinations.entries.forEachIndexed { index, destinations ->
                    NavigationBarItem(
                        selected = selectedDestination == index,
                        onClick = {
                            navController.navigate(route = destinations.route)
                            selectedDestination = index
                        },
                        icon = {
                            Icon(
                                destinations.icon,
                                contentDescription = destinations.label
                            )
                        },
                        label = { Text(destinations.label) }
                    )
                }
            }
        }
    ) { contentPadding -> 
        AppNavHost(
            navController = navController, 
            startDestination = startDestination, 
            userDao = userDao,
            modifier = Modifier.padding(contentPadding)
        ) 
    }
}