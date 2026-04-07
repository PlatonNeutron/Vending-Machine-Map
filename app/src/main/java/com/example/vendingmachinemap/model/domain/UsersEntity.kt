package com.example.vendingmachinemap.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UsersEntity(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val userName : String,
    val profilePicturePath : String?,
    val description : String?,
    val mail : String,
    val mdpHash : String
)
