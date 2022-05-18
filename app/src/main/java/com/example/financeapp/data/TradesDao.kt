package com.example.financeapp.data

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface TradesDao {
    @Query("SELECT DISTINCT * From trades ")
    fun  getTrades() : Flow<List<Trades>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(trade:Trades)

    @Query("DELETE FROM trades")
    suspend fun deleteAll()

}