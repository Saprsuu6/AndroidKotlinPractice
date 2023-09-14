package com.example.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity("Reports")
data class Report(
    @PrimaryKey(true) val key: Int,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("phoneNumbers") val phoneNumbers: String,
    @ColumnInfo("emails") val emails: String,
    @ColumnInfo("photoUri") val photoUri: String,
    @ColumnInfo("dateSend") val dateSend: String
)