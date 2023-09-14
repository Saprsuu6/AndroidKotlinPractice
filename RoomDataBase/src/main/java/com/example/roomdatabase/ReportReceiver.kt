package com.example.roomdatabase

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.google.gson.GsonBuilder
import de.hdodenhof.circleimageview.BuildConfig
import java.util.concurrent.Executors

class ReportReceiver() : BroadcastReceiver() {
    private val gson = GsonBuilder().create()
    private lateinit var roomDB: MainRoomDB
    private lateinit var reportsAdapter: ReportViewAdapter

    constructor(
        roomDB: MainRoomDB, reportsAdapter: ReportViewAdapter
    ) : this() {
        this.roomDB = roomDB
        this.reportsAdapter = reportsAdapter
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        val report = intent?.getStringExtra("report")
        val reportObj = gson.fromJson(report, Report::class.java)

        Executors.newFixedThreadPool(1).execute {
            roomDB.getDao().insertReport(reportObj) // add report to local db
        }

        reportsAdapter.addReport(reportObj) // add report to view adapter
    }
}