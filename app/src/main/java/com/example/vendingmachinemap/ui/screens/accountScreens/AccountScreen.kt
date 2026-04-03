package com.example.vendingmachinemap.ui.screens.accountScreens

// Imports
import android.widget.Toast
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vendingmachinemap.ui.screens.AppStates
import com.example.vendingmachinemap.ui.screens.accountScreens.accountDetailsScreen.AccountDetailsScreen

import com.example.vendingmachinemap.ui.screens.accountScreens.loginScreen.LoginContent
import com.example.vendingmachinemap.ui.theme.VendingMachineMapTheme

@Composable
fun AccountScreen(viewModel: AccountViewModel = viewModel()) {
    val state = viewModel.getState()
    println(state)

    when (state) {
        AppStates.UiStates.Account.SignedOut -> LoginContent()
        AppStates.UiStates.Account.SignedIn -> AccountDetailsScreen()
        else -> ErrorLogin(state)
    }
}

@Composable
fun ErrorLogin(error: AppStates.UiStates.Account) {
    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) { Text("OK") }
            },
            title = { Text("Erreur !!") },
            text = { Text("$error") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VendingMachineMapTheme {
        AccountScreen()
    }
}