package com.example.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database([Report::class], version = 1)
abstract class MainRoomDB : RoomDatabase() {
    abstract fun getDao(): Dao

    companion object {
        fun makeInstance(context: Context): MainRoomDB {
            return Room.databaseBuilder(
                context.applicationContext, MainRoomDB::class.java, "MainRoomDB.db"
            ).build()
        }
    }
}