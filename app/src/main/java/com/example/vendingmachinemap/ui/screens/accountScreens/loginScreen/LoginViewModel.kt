package com.example.vendingmachinemap.ui.screens.accountScreens.loginScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vendingmachinemap.model.data.dao.UsersDAO
import com.example.vendingmachinemap.ui.screens.AppStates
import com.example.vendingmachinemap.ui.screens.accountScreens.AccountViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class LoginViewModel(val dao: UsersDAO) : ViewModel(){
}