package com.example.sqlite

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.contentValuesOf
import com.example.sqlite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dbHelper: DBHelper
    private lateinit var sqLiteDatabase: SQLiteDatabase

    // SLQLite have INSERT() UPDATE(), DELETE() QUERY() for read, execQSL()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = DBHelper(applicationContext, null)
        sqLiteDatabase = dbHelper.writableDatabase

        val contentValues = contentValuesOf()

        binding.apply {
            add.setOnClickListener {
                contentValues.put(DBHelper.KEY_NAME, name.text.toString())
                contentValues.put(DBHelper.KEY_MAIL, email.text.toString())

                sqLiteDatabase.insert(DBHelper.TABLE_CONTACTS, null, contentValues)
            }

            // Cursor have
            // moveToFirst() - move to first string of query
            // moveToNext() - move cursor to next string
            // moveToLast() - move cursor to last string
            // moveToPrevious() - move cursor to previous string
            // getCount() - get amount of string from query
            // getColumnIndexOrThrow() - get index of column with current index
            // getColumnName() - get name of column with current index
            // getColumnNames() - get array of name in current cursor
            // moveToPosition() - move cursor to current row
            // getPosition() - get position of cursor
            // isBeforeFirst() - get value if cursor position before first
            // isAfterLast() - get value if cursor position after last
            // isClosed() - get value if cursor closed


            read.setOnClickListener {
                val cursor = sqLiteDatabase.query(
                    DBHelper.TABLE_CONTACTS, null, null, null, null, null, null
                )

                if (cursor.moveToFirst()) {
                    val idIndex = cursor.getColumnIndex(DBHelper.KEY_ID)
                    val nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME)
                    val emailIndex = cursor.getColumnIndex(DBHelper.KEY_MAIL)

                    do {
                        Log.d(
                            "myLog",
                            "ID = ${cursor.getInt(idIndex)}, name = ${cursor.getString(nameIndex)}, email = ${
                                cursor.getString(emailIndex)
                            }"
                        )
                    } while (cursor.moveToNext())
                }

                cursor.close()
            }

            clear.setOnClickListener {
                sqLiteDatabase.delete(DBHelper.TABLE_CONTACTS, null, null)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        dbHelper.close()
    }
}