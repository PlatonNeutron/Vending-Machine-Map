package com.example.vendingmachinemap.model.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.vendingmachinemap.model.domain.UsersEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDAO {
    @Query("SELECT mail, mdpHash FROM users")
    fun getCredentials(mail: String) : Flow<List<UsersEntity>>
}