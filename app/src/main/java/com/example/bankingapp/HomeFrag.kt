package com.example.bankingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.Nullable

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFrag.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFrag : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment_home, container, false)
        val tv: TextView = v.findViewById(R.id.tvdataOnresume)

        val context = activity
        val db = context?.let { DataBaseHandler(it) }
        val btnWithdraw = v.findViewById<Button>(R.id.btnWithdraw)
        val btnRead = v.findViewById<Button>(R.id.btnRead)
        val btnDeposit = v.findViewById<Button>(R.id.btnDeposit)
        val tvResult = v.findViewById<TextView>(R.id.tvResult)
        val editTextDeposit = v.findViewById<EditText>(R.id.editTextDeposit)
        val editTextWithdraw = v.findViewById<EditText>(R.id.editTextWithdraw)

        //displaying the current balance onresuming the activity
        val dataOnresume = db?.lastItem()
        if(!dataOnresume.isNullOrEmpty()){
            val lastBalance = dataOnresume!![0].deposit.toString()
            tv.text = lastBalance
        }



        btnWithdraw.setOnClickListener {
            val data = db?.lastItem()
            if (editTextWithdraw.text.toString().isNotEmpty()) {
                //adding the deposited amount to the old balance in the db
                val currentTotal =
                    data?.get(0)?.deposit?.minus(editTextWithdraw.text.toString().toInt())
                val user = currentTotal?.let { it1 -> User(editTextWithdraw.text.toString().toInt(), it1,"Withdraw") }

                //adding the new balance to the db
                if (user != null) db.insertData(user)

                //displaying the current balance onDepositing the activity
                tv.text = currentTotal.toString()
                Toast.makeText(activity, currentTotal?.toString(), Toast.LENGTH_LONG).show()

            } else {
                editTextWithdraw.setError("please the amount to withdraw")
            }
        }


        btnRead.setOnClickListener {
            val data = db?.readData()
            tvResult.text = ""
            for (i in 0 until data?.size!!) {
                tvResult.append(
//                    " " + data[i].deposit + " " + data[i].withdraw + " " + data[i].transactionType + "\n"
                "You made " + data[i].transactionType +" transaction of amount " + data[i].withdraw + " your current balance " + data[i].deposit +"\n\n\n"
                )
            }
        }


        btnDeposit.setOnClickListener {
            val data = db?.lastItem()
            if (editTextDeposit.text.toString().isNotEmpty()) {
                //adding the deposited amount to the old balance in the db

                val currentTotal =
                    data?.get(0)?.deposit?.plus(editTextDeposit.text.toString().toInt())

                val user = User(0, currentTotal!!,"Deposit")

                //adding the new balance to the db
                if (user != null) db.insertData(user)

                //displaying the current balance onDepositing the activity
                tv.text = currentTotal.toString()
                Toast.makeText(activity, currentTotal?.toString(), Toast.LENGTH_LONG).show()

            } else {
                editTextDeposit.setError("please the amount to Deposit")
            }
        }


        return v

    }

}