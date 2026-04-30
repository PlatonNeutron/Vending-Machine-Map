package com.example.vendingmachinemap.ui.screens.accountScreens.accountDetailsScreen

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

import com.example.vendingmachinemap.ui.screens.AppStates
import com.example.vendingmachinemap.ui.screens.accountScreens.AccountViewModel
import com.example.vendingmachinemap.R

@Composable
fun AccountDetailsScreen(viewModel: AccountViewModel) {
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
                    text = "Mon Compte"
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.default_profile_picture_placeholder),
                contentDescription = "Profile Picture",
                modifier = Modifier.size(200.dp)
            )
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Information du compte (sera dynamique par la suite)",
            )
            Button(
                onClick = { viewModel.setState(AppStates.UiStates.Account.SignedOut) }
            ) {
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "Sign Out",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Se déconnecter")
            }
            Button(
                onClick = { viewModel.setState(AppStates.UiStates.Account.SignedOut) }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Account",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Supprimer mon compte")
            }
        }
    }
}
