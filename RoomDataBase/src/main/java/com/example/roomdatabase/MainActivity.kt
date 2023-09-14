package com.example.roomdatabase

import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var roomDB: MainRoomDB

    private val reportsAdapter = ReportViewAdapter()
    private val reportReceiver by lazy { makeReceiver() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            roomDB = MainRoomDB.makeInstance(applicationContext)
        } catch (e: Exception) {
            println(e.message)
        }

        binding.apply {
            reports.layoutManager = LinearLayoutManager(this@MainActivity.applicationContext)
            reports.adapter = reportsAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        val filter = IntentFilter("com.example.sendmessage.SEND_REPORT_RECEIVER")
        filter.priority = 1
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(reportReceiver, filter, Context.RECEIVER_EXPORTED)
        } else {
            ContextCompat.registerReceiver(
                applicationContext, reportReceiver, filter, ContextCompat.RECEIVER_EXPORTED
            )
        }
    }

    private fun makeReceiver(): BroadcastReceiver {
        return ReportReceiver(roomDB, reportsAdapter)
    }
}