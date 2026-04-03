package com.example.vendingmachinemap.ui.screens.addMachineScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Ajouter un distributeur",
            style = MaterialTheme.typography.headlineMedium
        )

        // Localisation
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("Localisation détectée", style = MaterialTheme.typography.titleMedium)
            Surface(
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = viewModel.address,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        // Nom du distributeur
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("Nom du distributeur", style = MaterialTheme.typography.titleMedium)
            TextField(
                value = viewModel.name,
                onValueChange = { viewModel.name = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Entrée sud Barbès-Rochechouart") },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }

        // Type de produit vendu (descritpion)
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("Type de produits", style = MaterialTheme.typography.titleMedium)
            TextField(
                value = viewModel.description,
                onValueChange = { viewModel.description = it },
                modifier = Modifier.fillMaxWidth().height(100.dp),
                placeholder = { Text("Ex: Boissons fraîches, Snacks...") },
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }

        // Note / 5
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("Note globale : ${viewModel.rating}/5", style = MaterialTheme.typography.titleMedium)
            Slider(
                value = viewModel.rating.toFloat(),
                onValueChange = { viewModel.rating = it.toInt() },
                valueRange = 1f..5f,
                steps = 3
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Bouton valider
        Button(
            onClick = { viewModel.saveMachine { onNavigateBack() } },
            modifier = Modifier.fillMaxWidth().height(56.dp),
            enabled = (viewModel.currentLatLng != null) && (viewModel.name.isNotBlank()),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(if (viewModel.currentLatLng != null) "Enregistrer" else "Localisation en cours...")
        }
    }
}