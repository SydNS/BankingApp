package com.example.bankingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        title = "KotlinApp"
        val context = this
        val db = DataBaseHandler(context)
        val btnInsert=findViewById<Button>(R.id.btnInsert)
        val btnRead=findViewById<Button>(R.id.btnRead)
        val tvResult=findViewById<TextView>(R.id.tvResult)
        val editTextName=findViewById<EditText>(R.id.editTextName)
        val editTextAge=findViewById<EditText>(R.id.editTextAge)
        btnInsert.setOnClickListener {
            if (editTextName.text.toString().isNotEmpty() &&
                editTextAge.text.toString().isNotEmpty()
            ) {
                val user = User(editTextAge.text.toString().toInt(),editTextName.text.toString())
                db.insertData(user)
//                clearField()
            }
            else {
                Toast.makeText(context, "Please Fill All Data's", Toast.LENGTH_SHORT).show()
            }
        }
        btnRead.setOnClickListener {
            val data = db.readData()
            tvResult.text = ""
            for (i in 0 until data.size) {
                tvResult.append( " " + data[i].name + " " + data[i].age + "\n"
                )
            }
        }
    }
//    private fun clearField() {
//        editTextName.text.clear()
//        editTextAge.text.clear()
//    }
}