package com.example.financeapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// export schema миграция базы данных
@Database(entities = arrayOf(Trades::class), version = 1, exportSchema = false)
public abstract class TradesRoomDatabase : RoomDatabase() {
    abstract fun tradesDao() : TradesDao


    companion object {
        //синглтон чтобы предотвратить одновременное открытие нескольких экземпляров баз данных
        private var INSTANSE:  TradesRoomDatabase? = null


        //возращает синглтон
        fun getDatabase(context: Context) : TradesRoomDatabase{
            // создание базы данных при первом обращении
            return INSTANSE ?: synchronized(this){
                val instanse = Room.databaseBuilder(
                    context.applicationContext,TradesRoomDatabase::class.java,"trades"
                ).build()
                INSTANSE = instanse
                instanse
            }

        }
    }

}