package com.example.vendingmachinemap.model.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.vendingmachinemap.model.domain.UsersEntity
import com.example.vendingmachinemap.model.domain.VendingMachinesEntity
import com.example.vendingmachinemap.model.domain.VendingPicturesEntity
import com.example.vendingmachinemap.model.domain.VendingRatingEntity
import com.example.vendingmachinemap.model.data.dao.UsersDAO
import com.example.vendingmachinemap.model.data.dao.VendingMachinesDAO
import com.example.vendingmachinemap.model.data.dao.VendingPicturesDAO
import com.example.vendingmachinemap.model.data.dao.VendingRatingDAO

@Database(
    entities = [
        UsersEntity::class,
        VendingMachinesEntity::class,
        VendingPicturesEntity::class,
        VendingRatingEntity::class],
    version = 1)
abstract class VendingMachinesAppDatabase : RoomDatabase() {
    abstract fun userDao() : UsersDAO

    abstract fun vendingMachinesDao() : VendingMachinesDAO

    abstract fun vendingPicturesDao() : VendingPicturesDAO

    abstract fun vendingRatingDao() : VendingRatingDAO
}