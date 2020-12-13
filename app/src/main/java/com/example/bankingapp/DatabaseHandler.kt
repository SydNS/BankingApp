package com.example.bankingapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast


val DATABASENAME = "BANK ACCOUNT"
val TABLENAME = "Users"
val COL_ACCOUNTBALANCE = "Deposit"
val COL_TRANSACTION_TYPE = "TransactionType"
val COL_WITHDRAW = "withdrawn"
val COL_ID = "id"

class DataBaseHandler(var context: Context) : SQLiteOpenHelper(
    context, DATABASENAME, null,
    1
) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable =
            "CREATE TABLE $TABLENAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,$COL_ACCOUNTBALANCE INTEGER,$COL_WITHDRAW INTEGER,$COL_TRANSACTION_TYPE STRING)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //onCreate(db);
    }

    fun insertData(user: User) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_ACCOUNTBALANCE, user.deposit)
        contentValues.put(COL_WITHDRAW, user.withdraw)
        contentValues.put(COL_TRANSACTION_TYPE, user.transactionType)
        val result = database.insert(TABLENAME, null, contentValues)
        if (result == (0).toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }
    }

    fun readData(): MutableList<User> {
        val list: MutableList<User> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLENAME"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
//                val id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                val deposit = result.getString(result.getColumnIndex(COL_ACCOUNTBALANCE)).toInt()
                val withdraw = result.getString(result.getColumnIndex(COL_WITHDRAW)).toInt()
                val transactiontype = result.getString(result.getColumnIndex(COL_TRANSACTION_TYPE))
                var user = User(withdraw, deposit,transactiontype)
                list.add(user)
            } while (result.moveToNext())
        }
        return list
    }

    fun lastItem(): MutableList<User> {
        val list: MutableList<User> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLENAME "
        val result = db.rawQuery(query, null)
        if (result.moveToLast()) {
            val deposit = result.getString(result.getColumnIndex(COL_ACCOUNTBALANCE)).toInt()
            val withdraw = result.getString(result.getColumnIndex(COL_WITHDRAW)).toInt()
            val transactiontype = result.getString(result.getColumnIndex(COL_TRANSACTION_TYPE))
            var user = User(withdraw, deposit,transactiontype)
            list.add(user)
        }
        return list
    }


}