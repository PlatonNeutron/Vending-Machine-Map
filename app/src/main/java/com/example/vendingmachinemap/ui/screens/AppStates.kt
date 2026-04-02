package com.example.vendingmachinemap.ui.screens

// Sealed interface containing all possible states of the app
sealed interface AppStates {

    // Sealed interface containing all possible states of the UI
    sealed interface UiStates {

        // Sealed interface containing all possible states of the account UI
        sealed interface Account {
            data object SignedOut : Account

            data object Loading : Account

            data object SignedIn : Account

            data class Error(val message: String) : Account
        }
    }
}