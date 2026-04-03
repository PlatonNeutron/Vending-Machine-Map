package com.example.vendingmachinemap.ui.screens.accountScreens

// Imports
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vendingmachinemap.ui.screens.AppStates

import com.example.vendingmachinemap.ui.screens.accountScreens.loginScreen.LoginContent
import com.example.vendingmachinemap.ui.theme.VendingMachineMapTheme

@Composable
fun AccountScreen(viewModel: AccountViewModel = viewModel()) {
    val test = viewModel.getState()
    println(test)

    when (test) {
        AppStates.UiStates.Account.SignedOut -> LoginContent()
        /*AppStates.UiStates.Account.SignedIn -> AccountContent()*/
        else -> AccountContent()
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