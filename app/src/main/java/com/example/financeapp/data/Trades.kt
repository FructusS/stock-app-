package com.example.financeapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
//table name
@Entity(tableName = "trades")
data class Trades(


    @PrimaryKey(autoGenerate = true)   var id: Int,
    //имя столбцов
    @ColumnInfo(name = "Title") var name: String?,
   @ColumnInfo(name = "StockTrade") var cost: Double?
)

