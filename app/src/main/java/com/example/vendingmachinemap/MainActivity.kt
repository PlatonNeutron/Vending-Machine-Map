package com.example.vendingmachinemap

// Imports
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.LocationOn
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vendingmachinemap.ui.theme.VendingMachineMapTheme
import com.example.vendingmachinemap.navigation.Destinations

// MainActivity
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VendingMachineMapTheme {
                NavigationBar()
            }
        }
    }
}

// Déclaration des composables
// Déclaration des différents écrans
@Composable
fun MapScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Map Screen")
    }
}

@Composable
fun AccountScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Account Screen")
    }
}

// Logique de la navigation
// NavHost
@Composable
fun AppNavHost(navController: NavHostController, startDestination: Destinations, modifier: Modifier = Modifier) {
    NavHost(navController, startDestination = startDestination.route) {
        Destinations.entries.forEach { destinations -> composable(destinations.route) {
                when (destinations) {
                    Destinations.Map -> MapScreen()
                    Destinations.Account -> AccountScreen()
                }
            }
        }
    }
}

// Déclaration des components
@Composable
fun NavigationBar() {
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
    ) { contentPadding -> AppNavHost(navController, startDestination, modifier = Modifier.padding(contentPadding)) }
}







@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VendingMachineMapTheme {
        NavigationBar()
    }
}