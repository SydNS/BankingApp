package com.example.bankingapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class CustomAdapter(val userList: ArrayList<User>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rowlayout, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.bindItems(userList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: User) {
            val typeOfTransaction = itemView.findViewById(R.id.typeOfTransaction) as TextView
            val amountOfMoneyCharged  = itemView.findViewById(R.id.amountOfMoneyCharged) as TextView
            val amountOfMoney  = itemView.findViewById(R.id.amountOfMoney) as TextView
            val amountBalance  = itemView.findViewById(R.id.amountBalance) as TextView

            typeOfTransaction.text = user.transactionType.toString()
            amountOfMoneyCharged.text = user.withdraw_charges.toString()
            amountOfMoney.text = user.withdraw.toString()
            amountBalance.text = user.deposit.toString()
        }
    }
}

