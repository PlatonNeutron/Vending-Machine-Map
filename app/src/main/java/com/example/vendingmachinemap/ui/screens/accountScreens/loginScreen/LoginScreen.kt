package com.example.vendingmachinemap.ui.screens.accountScreens.loginScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.vendingmachinemap.ui.theme.VendingMachineMapTheme
import com.example.vendingmachinemap.ui.screens.accountScreens.AccountViewModel

@Composable
fun LoginContent(viewModel: AccountViewModel = viewModel()) {
    var userMail by remember { mutableStateOf("") }
    var userPass by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(modifier = Modifier
                    .width(150.dp)
                    .height(30.dp)
                    .background(Color.Yellow),

                    textAlign = TextAlign.Center,
                    text = "Se connecter"
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextField(
                value = userMail,
                onValueChange = { userMail = it },
                label = { Text("Label") }
            )
            TextField(
                value = userPass,
                onValueChange = { userPass = it },
                label = { Text("Label") }
            )
            Row() {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Pas de compte ?",
                )
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Créer un compte",
                )
            }
            Button(
                onClick = { viewModel.loginButtonCliqued(userMail, userPass) }
            ) {
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "Add Item",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Se connecter")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VendingMachineMapTheme {
        LoginContent()
    }
}