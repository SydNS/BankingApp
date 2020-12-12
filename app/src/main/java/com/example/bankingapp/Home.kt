package com.example.bankingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : AppCompatActivity() {
    val context = this
    val db = DataBaseHandler(context)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)//so that the hoe fragment i shown immediately

        isFirstTime

        val bottomnav=findViewById<BottomNavigationView>(R.id.bottomnav)
        bottomnav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> {
//                    Toast.makeText(this, "aysy", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFrag())
                        .commit()
                }
                R.id.menu_profile ->{
//                    Toast.makeText(this, "Transactions", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container,AccountInfo() )
                        .commit()
                }
                R.id.transactions->{
//                    Toast.makeText(this, "Transactions", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, Transactions())
                        .commit()
                }
            }
            true
        }

    }

    private val isFirstTime:
    //default value true
            Unit
        get() {
            //for checking if the app is running for the very first time
            //we need to save a value to shared preferences
            val preferences = application.getSharedPreferences("onBoard", MODE_PRIVATE)
            val isFirstTime = preferences.getBoolean("isFirstTime", true)
            //default value true

            if (isFirstTime) {
                // if its true then its first time and we will change it false
                val editor = preferences.edit()
                editor.putBoolean("isFirstTime", false)
                editor.apply()

                // start Onboard activity
                val user = User(0, 0)
                //adding the new balance to the db
                db.insertData(user)
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFrag())
                    .commit()

            } else {
                //start Auth Activity

                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFrag())
                    .commit()
            }
        }


}