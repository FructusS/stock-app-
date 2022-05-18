package com.example.financeapp.repository

import androidx.annotation.WorkerThread
import com.example.financeapp.data.Trades
import com.example.financeapp.data.TradesDao
import kotlinx.coroutines.flow.Flow

class TradesRepository (private val tradesDao: TradesDao) {

    val allTrades : Flow<List<Trades>>  = tradesDao.getTrades()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(trade: Trades) {
        tradesDao.insert(trade)
    }

}