package com.example.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(
    context: Context, factory: SQLiteDatabase.CursorFactory?
) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    companion object {
        const val DATABASE_VERSION: Int = 1
        const val DATABASE_NAME: String = "contactDB"
        const val TABLE_CONTACTS: String = "contacts"

        const val KEY_ID: String = "_id"
        const val KEY_NAME: String = "name"
        const val KEY_MAIL: String = "mail"
    }

    /**
     * et DB for write
     */
    override fun getWritableDatabase(): SQLiteDatabase {
        return super.getWritableDatabase() // g
    }

    /**
     * get DB for read
     */
    override fun getReadableDatabase(): SQLiteDatabase {
        return super.getReadableDatabase() //
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table $TABLE_CONTACTS (${KEY_ID} integer primary key, $KEY_NAME text, $KEY_MAIL text)")
    }

    /**
     * when version in annotation is higher the notify in DB
     */
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    /**
     * when version in annotation is smallest the notify in DB
     */
    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        super.onDowngrade(db, oldVersion, newVersion)

        db?.execSQL("drop table if exists $TABLE_CONTACTS")
        onCreate(db)
    }

    /**
     * when DB open
     */
    override fun onOpen(db: SQLiteDatabase?) {
        super.onOpen(db)
    }
}