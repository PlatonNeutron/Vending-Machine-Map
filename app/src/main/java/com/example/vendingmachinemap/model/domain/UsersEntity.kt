package com.example.vendingmachinemap.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UsersEntity(
    @PrimaryKey() val mail : String,
    val userName : String,
    val profilePicturePath : String?,
    val description : String?,
    val mdpHash : String
)
