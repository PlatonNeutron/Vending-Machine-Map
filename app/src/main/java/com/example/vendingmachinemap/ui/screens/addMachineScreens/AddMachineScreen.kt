package com.example.vendingmachinemap.ui.screens.addMachineScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AddMachineScreen(
    viewModel: AddMachineViewModel = viewModel(),
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.fetchCurrentLocation(context)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // Title
        Text(
            text = "Ajouter un distributeur",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        // Location
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("Localisation du distributeur", style = MaterialTheme.typography.titleMedium)
            Text(
                text = viewModel.address,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        // Description / Comment
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("Commentaire", style = MaterialTheme.typography.titleMedium)

            TextField(
                value = viewModel.comment,
                onValueChange = { viewModel.comment = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                placeholder = { Text("Ceci est un commentaire...") },
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
        }

        // Note / 5
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("Note", style = MaterialTheme.typography.titleMedium)
            Slider(
                value = viewModel.rating.toFloat(),
                onValueChange = { viewModel.rating = it.toInt() },
                valueRange = 1f..5f,
                steps = 3,
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colorScheme.primary,
                    activeTrackColor = MaterialTheme.colorScheme.primary
                )
            )
            Text("Note sélectionnée : ${viewModel.rating} / 5", style = MaterialTheme.typography.bodyMedium)
        }

        Spacer(modifier = Modifier.weight(1f))

        // Add button
        Button(
            onClick = {
                viewModel.saveMachine { onNavigateBack() }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            enabled = viewModel.currentLatLng != null,
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Text(
                text = if (viewModel.currentLatLng != null) "Ajouter le distributeur" else "Recherche GPS...",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}