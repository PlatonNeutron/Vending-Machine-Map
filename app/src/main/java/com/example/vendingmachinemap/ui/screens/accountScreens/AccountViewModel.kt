package com.example.vendingmachinemap.ui.screens.accountScreens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.vendingmachinemap.ui.screens.AppStates
import androidx.compose.runtime.State
import com.example.vendingmachinemap.model.data.dao.UsersDAO

class AccountViewModel(val dao: UsersDAO) : ViewModel() {
    private var _uiState = mutableStateOf<AppStates.UiStates.Account>(AppStates.UiStates.Account.SignedOut)
    val uiState: State<AppStates.UiStates.Account> = _uiState

    fun setState(newState: AppStates.UiStates.Account) {
        _uiState.value = newState
    }

    fun getState() : AppStates.UiStates.Account {
        return uiState.value
    }

    // Temporaire le temps qu'un repository soit implémenter pour déléguer cette fct au LoginViewModel
    fun loginButtonCliqued(mail : String, password : String) {
        // à changer par connexion et check à la BDD
        if (mail == "test" && password == "test") {
            this.setState(AppStates.UiStates.Account.SignedIn)
        }
        else {
            this.setState(AppStates.UiStates.Account.Error("Mauvais email ou mot de passe !"))
        }
    }
}