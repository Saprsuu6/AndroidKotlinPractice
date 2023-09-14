package com.example.roomdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
    fun insertReport(report: Report)

    @Query("SELECT * FROM Reports")
    fun getAllReports(): Flow<List<Report>>
}