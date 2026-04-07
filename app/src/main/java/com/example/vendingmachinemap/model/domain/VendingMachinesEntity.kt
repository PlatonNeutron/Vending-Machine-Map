package com.example.vendingmachinemap.model.domain

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "vendingMachines",
    foreignKeys = [
        ForeignKey(entity = UsersEntity::class,
            parentColumns = ["id"],
            childColumns = ["addedBy"])])
data class VendingMachinesEntity(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val name : String?,
    val lat : Double,
    val long : Double,
    val createdAt : Long,
    val addedBy : Int
)
