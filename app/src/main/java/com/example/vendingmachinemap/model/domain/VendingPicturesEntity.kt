package com.example.vendingmachinemap.model.domain

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "vendingPictures",
    primaryKeys = [
        "vendingId",
        "addedBy",
        "picturePath"],
    foreignKeys = [
        ForeignKey(
            entity = UsersEntity::class,
            parentColumns = ["mail"],
            childColumns = ["addedBy"]),
        ForeignKey(
            entity = VendingMachinesEntity::class,
            parentColumns = ["id"],
            childColumns = ["vendingId"])],
    indices = [
        Index("addedBy"),
        Index("vendingId")])
data class VendingPicturesEntity(
    val vendingId : Int = 0,
    val addedBy : String,
    val picturePath : String
)
