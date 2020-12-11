package com.example.bankingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var bottomnav=findViewById<BottomNavigationView>(R.id.bottomnav)
        bottomnav.setOnClickListener {
            when (it.id) {
                R.id.menu_home -> {
                    Toast.makeText(this,"herte",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu_notification -> {
                    Toast.makeText(this,"herte",Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}