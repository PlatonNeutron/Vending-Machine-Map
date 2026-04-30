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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.vendingmachinemap.ui.screens.AppStates
import com.example.vendingmachinemap.ui.screens.accountScreens.AccountViewModel
import com.example.vendingmachinemap.R
import com.example.vendingmachinemap.model.domain.UsersEntity

@Composable
fun AccountDetailsScreen(viewModel: AccountViewModel, user: UsersEntity) {
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
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.default_profile_picture_placeholder),
                contentDescription = "Profile Picture",
                modifier = Modifier.size(200.dp).align(Alignment.CenterHorizontally)
            )

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = user.userName,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                val descriptionText = if (!user.description.isNullOrBlank()) {
                    user.description
                } else {
                    "We don't know much about ${user.userName} but we are sure it's a cool person !"
                }

                Text(
                    text = descriptionText,
                    fontSize = 16.sp,
                    color = Color.Gray
                )

                Text(
                    text = user.mail,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { viewModel.setState(AppStates.UiStates.Account.SignedOut) },
                modifier = Modifier.fillMaxWidth()
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
                onClick = { viewModel.deleteUser(user) },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                modifier = Modifier.fillMaxWidth()
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
