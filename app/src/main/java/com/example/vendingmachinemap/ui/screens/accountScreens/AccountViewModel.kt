package com.example.vendingmachinemap.ui.screens.accountScreens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.vendingmachinemap.ui.screens.AppStates
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.vendingmachinemap.model.data.dao.UsersDAO
import com.example.vendingmachinemap.model.domain.UsersEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class AccountViewModel(val dao: UsersDAO) : ViewModel() {
    private var _uiState = mutableStateOf<AppStates.UiStates.Account>(AppStates.UiStates.Account.SignedOut)
    val uiState: State<AppStates.UiStates.Account> = _uiState

    fun setState(newState: AppStates.UiStates.Account) {
        _uiState.value = newState
    }

    fun getState() : AppStates.UiStates.Account {
        return uiState.value
    }

    // Login a user if the credentials are correct
    fun loginButtonCliqued(mail: String, mdpHash: String) {
        viewModelScope.launch {
            try {
                // On récupère la liste des utilisateurs correspondant au mail (devrait être 0 ou 1)
                // .first() permet de prendre la première émission du Flow puis de s'arrêter
                val users = dao.getCredentials(mail).first()
                val user = users.firstOrNull()

                if (user != null && user.mdpHash == mdpHash) {
                    setState(AppStates.UiStates.Account.SignedIn)
                } else {
                    setState(AppStates.UiStates.Account.Error("Mauvais email ou mot de passe !"))
                }
            } catch (e: Exception) {
                setState(AppStates.UiStates.Account.Error("Erreur lors de la connexion : ${e.message}"))
            }
        }
    }

    // Create a new user in the database
    fun createUser(mail: String, mdpHash: String) {
        viewModelScope.launch {
            try {
                val newUser = UsersEntity(
                    mail = mail,
                    userName = mail.split("@").firstOrNull() ?: "User",
                    profilePicturePath = null,
                    description = null,
                    mdpHash = mdpHash
                )
                dao.upsertUser(newUser)
                setState(AppStates.UiStates.Account.SignedIn)
            } catch (e: Exception) {
                setState(AppStates.UiStates.Account.Error("Erreur lors de la création du compte : ${e.message}"))
            }
        }
    }

    companion object {
        fun provideFactory(dao: UsersDAO): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                AccountViewModel(dao)
            }
        }
    }
}
