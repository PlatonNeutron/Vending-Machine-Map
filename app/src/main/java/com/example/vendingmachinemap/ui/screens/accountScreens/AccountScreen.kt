package com.example.vendingmachinemap.ui.screens.accountScreens

// Imports
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vendingmachinemap.model.data.dao.UsersDAO
import com.example.vendingmachinemap.ui.screens.AppStates
import com.example.vendingmachinemap.ui.screens.accountScreens.accountDetailsScreen.AccountDetailsScreen
import com.example.vendingmachinemap.ui.screens.accountScreens.loginScreen.LoginContent
import com.example.vendingmachinemap.ui.screens.accountScreens.signUpScreen.CreateAccountContent

@Composable
fun AccountScreen(dao: UsersDAO) {
    val viewModel: AccountViewModel = viewModel(factory = AccountViewModel.provideFactory(dao))
    val state = viewModel.getState()

    when (state) {
        AppStates.UiStates.Account.SignedOut -> LoginContent(viewModel = viewModel)
        is AppStates.UiStates.Account.SignedIn -> AccountDetailsScreen(viewModel = viewModel, user = state.user)
        AppStates.UiStates.Account.CreatingAccount -> CreateAccountContent(viewModel = viewModel)
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
