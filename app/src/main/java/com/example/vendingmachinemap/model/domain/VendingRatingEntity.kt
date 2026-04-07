package com.example.vendingmachinemap.model.domain

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "vendingRating",
    primaryKeys = [
        "vendingId",
        "addedBy"],
    foreignKeys = [
        ForeignKey(
            entity = UsersEntity::class,
            parentColumns = ["id"],
            childColumns = ["addedBy"]),
        ForeignKey(
            entity = VendingMachinesEntity::class,
            parentColumns = ["id"],
            childColumns = ["vendingId"])],
    indices = [
        Index("addedBy"),
        Index("vendingId")])
data class VendingRatingEntity(
    val vendingId : Int = 0,
    val addedBy : Int,
    val vendingRating : Double,
    val vendingReview : String
)
