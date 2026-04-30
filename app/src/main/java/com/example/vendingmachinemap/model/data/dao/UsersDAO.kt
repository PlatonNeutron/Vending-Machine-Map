package com.example.vendingmachinemap.model.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.vendingmachinemap.model.domain.UsersEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDAO {

    @Upsert
    suspend fun upsertUser(usersEntity: UsersEntity)

    @Delete
    suspend fun deleteUser(usersEntity: UsersEntity)

    @Query("SELECT * FROM users WHERE mail = :mail")
    fun getCredentials(mail: String) : Flow<List<UsersEntity>>
}