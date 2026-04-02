package com.example.vendingmachinemap.ui.screens.accountScreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.vendingmachinemap.ui.theme.VendingMachineMapTheme

const val isConnected = true

@Composable
fun AccountScreen() {
    if (isConnected) {
        AccountContent()
    }
    else {
        ConnexionContent()
    }
}

@Composable
fun ConnexionContent() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Non connecté")
    }
}

@Composable
fun AccountContent() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Connecté")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VendingMachineMapTheme {
        AccountScreen()
    }
}