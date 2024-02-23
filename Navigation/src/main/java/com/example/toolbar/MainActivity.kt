package com.example.toolbar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.toolbar.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Instagram"

        binding.apply {
            navBottomMenu.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.myHome -> {
                        Toast.makeText(this@MainActivity, "home", Toast.LENGTH_SHORT).show()
                        true
                    }

                    R.id.search -> {
                        Toast.makeText(this@MainActivity, "search", Toast.LENGTH_SHORT).show()
                        true
                    }

                    R.id.add -> {
                        Toast.makeText(this@MainActivity, "add", Toast.LENGTH_SHORT).show()
                        true
                    }

                    R.id.news -> {
                        Toast.makeText(this@MainActivity, "news", Toast.LENGTH_SHORT).show()
                        true
                    }

                    R.id.page -> {
                        Toast.makeText(this@MainActivity, "page", Toast.LENGTH_SHORT).show()
                        true
                    }

                    else -> false
                }
            }
            navigationView.setNavigationItemSelectedListener {
                drawer.closeDrawer(GravityCompat.START)
                true
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            R.id.sync -> Toast.makeText(this, "sync", Toast.LENGTH_SHORT).show()
            R.id.save -> Toast.makeText(this, "save", Toast.LENGTH_SHORT).show()
            R.id.search -> Toast.makeText(this, "search", Toast.LENGTH_SHORT).show()
            R.id.delete -> Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show()
        }

        return true
    }
}