package com.example.vendingmachinemap

// Imports
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.room.Room
import com.example.vendingmachinemap.model.data.database.VendingMachinesAppDatabase

import com.example.vendingmachinemap.ui.theme.VendingMachineMapTheme
import com.example.vendingmachinemap.ui.components.NavigationBar
import kotlin.getValue


// MainActivity
class MainActivity : ComponentActivity() {
    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            VendingMachinesAppDatabase::class.java,
            "VendingMachinesApp.db"
        ).build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VendingMachineMapTheme {
                NavigationBar(userDao = db.userDao())
            }
        }
    }
}
