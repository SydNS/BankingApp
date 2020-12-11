package com.example.bankingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var bottomnav=findViewById<BottomNavigationView>(R.id.bottomnav)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFrag())
            .commit()
        bottomnav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> {
                    Toast.makeText(this, "aysy", Toast.LENGTH_SHORT).show()
                    val fragment = HomeFrag()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFrag())
                        .commit()
                }
                R.id.menu_profile ->{
                    Toast.makeText(this, "Transactions", Toast.LENGTH_SHORT).show()
                    val fragment = Transactions()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFrag())
                        .commit()
                }
                R.id.menu_notification->Toast.makeText(this,"menu_noti",Toast.LENGTH_SHORT).show()

            }
            true
        }

    }
}