package com.example.bankingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)//so that the hoe fragment i shown immediately
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFrag())
            .commit()

        val bottomnav=findViewById<BottomNavigationView>(R.id.bottomnav)
        bottomnav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> {
                    Toast.makeText(this, "aysy", Toast.LENGTH_SHORT).show()

                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFrag())
                        .commit()
                }
                R.id.menu_profile ->{
                    Toast.makeText(this, "Transactions", Toast.LENGTH_SHORT).show()

                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFrag())
                        .commit()
                }
                R.id.menu_notification->Toast.makeText(this,"menu_noti",Toast.LENGTH_SHORT).show()

            }
            true
        }

    }
}