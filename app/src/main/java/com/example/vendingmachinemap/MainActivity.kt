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
// Liste des destinations
enum class Destination(
    val label: String,
    val route: String,
    val icon: ImageVector
) {
    Map("Map", "map_screen", Icons.Default.LocationOn),
    Account("Account", "account_screen", Icons.Default.AccountCircle)
}

// NavHost
@Composable
fun AppNavHost(navController: NavHostController, startDestination: Destination, modifier: Modifier = Modifier) {
    NavHost(navController, startDestination = startDestination.route) {
        Destination.entries.forEach { destination -> composable(destination.route) {
                when (destination) {
                    Destination.Map -> MapScreen()
                    Destination.Account -> AccountScreen()
                }
            }
        }
    }
}

// Déclaration des components
@Composable
fun NavigationBar() {
    val navController = rememberNavController()
    val startDestination = Destination.Map
    var selectedDestination by rememberSaveable { mutableIntStateOf(startDestination.ordinal) }

    Scaffold(
        //modifier = modifier,
        bottomBar = {
            NavigationBar(windowInsets = NavigationBarDefaults.windowInsets) {
                Destination.entries.forEachIndexed { index, destination ->
                    NavigationBarItem(
                        selected = selectedDestination == index,
                        onClick = {
                            navController.navigate(route = destination.route)
                            selectedDestination = index
                        },
                        icon = {
                            Icon(
                                destination.icon,
                                contentDescription = destination.label
                            )
                        },
                        label = { Text(destination.label) }
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