package com.example.bankingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment

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
    ): View {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment_home, container, false)
        val tv: TextView = v.findViewById(R.id.tvdataOnresume)

        val context = activity
        val db = context?.let { DataBaseHandler(it) }

        val btnWithdraw = v.findViewById<Button>(R.id.btnWithdraw)
//        val btnRead = v.findViewById<Button>(R.id.btnRead)
        val btnDeposit = v.findViewById<Button>(R.id.btnDeposit)
        val tvResult = v.findViewById<TextView>(R.id.tvResult)
        val editAmount = v.findViewById<EditText>(R.id.amount)

        //displaying the current balance onresuming the activity
        val dataOnresume = db?.lastItem()
        if (!dataOnresume.isNullOrEmpty()) {
            val lastBalance = dataOnresume[0].deposit.toString()
            tv.text = lastBalance
        }


        btnWithdraw.setOnClickListener {
            val data = db?.lastItem()
            if (editAmount.text.toString().isNotEmpty()) {
                //adding the deposited amount to the old balance in the db
                val amountMoney = editAmount.text.toString().toInt()

                when (amountMoney) {
                    in 500..2500 -> {
                        val currentTotal =data?.get(0)?.deposit?.minus(amountMoney + 200)
                        val user = if (currentTotal != null) User(
                            amountMoney,
                            currentTotal,
                            "Withdraw",200
                        ) else null
                        //adding the new balance to the db
                        if (user != null) db?.insertData(user)
                        tv.text = currentTotal.toString()
                        Toast.makeText(activity, currentTotal?.toString(), Toast.LENGTH_LONG).show()

                    }
                    in 2501..5000 -> {
                        val currentTotal =data?.get(0)?.deposit?.minus(amountMoney + 450)
                        val user = if (currentTotal != null) User(
                            amountMoney,
                            currentTotal,
                            "Withdraw",450
                        ) else null
                        //adding the new balance to the db
                        if (user != null) db?.insertData(user)
                        tv.text = currentTotal.toString()
                        Toast.makeText(activity, currentTotal?.toString(), Toast.LENGTH_LONG).show()

                    }
                    in 5001..15000 -> {
                        val currentTotal =data?.get(0)?.deposit?.minus(amountMoney + 1000)
                        val user = if (currentTotal != null) User(
                            amountMoney,
                            currentTotal,
                            "Withdraw",1000
                        ) else null
                        //adding the new balance to the db
                        if (user != null) db?.insertData(user)
                        tv.text = currentTotal.toString()
                        Toast.makeText(activity, currentTotal?.toString(), Toast.LENGTH_LONG).show()

                    }
                    in 15001..30000 -> {
                        val currentTotal =data?.get(0)?.deposit?.minus(amountMoney + 1000)
                        val user = if (currentTotal != null) User(
                            amountMoney,
                            currentTotal,
                            "Withdraw",1000
                        ) else null
                        //adding the new balance to the db
                        if (user != null) db?.insertData(user)
                        tv.text = currentTotal.toString()
                        Toast.makeText(activity, currentTotal?.toString(), Toast.LENGTH_LONG).show()
                    }
                    in 30001..45000 -> {
                        val currentTotal =data?.get(0)?.deposit?.minus(amountMoney + 1550)
                        val user = if (currentTotal != null) User(
                            amountMoney,
                            currentTotal,
                            "Withdraw",1550
                        ) else null
                        //adding the new balance to the db
                        if (user != null) db?.insertData(user)
                        tv.text = currentTotal.toString()
                        Toast.makeText(activity, currentTotal?.toString(), Toast.LENGTH_LONG).show()

                    }
                    in 45001..60000 -> {
                        val currentTotal =data?.get(0)?.deposit?.minus(amountMoney + 1550)
                        val user = if (currentTotal != null) User(
                            amountMoney,
                            currentTotal,
                            "Withdraw",1550
                        ) else null
                        //adding the new balance to the db
                        if (user != null) db?.insertData(user)
                        tv.text = currentTotal.toString()
                        Toast.makeText(activity, currentTotal?.toString(), Toast.LENGTH_LONG).show()

                    }
                    in 60001..125000 -> {
                        val currentTotal =data?.get(0)?.deposit?.minus(amountMoney + 2050)
                        val user = if (currentTotal != null) User(
                            amountMoney,
                            currentTotal,
                            "Withdraw",2050
                        ) else null
                        //adding the new balance to the db
                        if (user != null) db?.insertData(user)
                        tv.text = currentTotal.toString()
                        Toast.makeText(activity, currentTotal?.toString(), Toast.LENGTH_LONG).show()

                    }
                    in 125001..250000 -> {
                        val currentTotal =data?.get(0)?.deposit?.minus(amountMoney + 2050)
                        val user = if (currentTotal != null) User(
                            amountMoney,
                            currentTotal,
                            "Withdraw",2050
                        ) else null
                        //adding the new balance to the db
                        if (user != null) db?.insertData(user)
                        tv.text = currentTotal.toString()
                        Toast.makeText(activity, currentTotal?.toString(), Toast.LENGTH_LONG).show()

                    }
                    in 250001..500000 -> {
                        val currentTotal =data?.get(0)?.deposit?.minus(amountMoney + 2050)
                        val user = if (currentTotal != null) User(
                            amountMoney,
                            currentTotal,
                            "Withdraw",2050
                        ) else null
                        //adding the new balance to the db
                        if (user != null) db?.insertData(user)
                        tv.text = currentTotal.toString()
                        Toast.makeText(activity, currentTotal?.toString(), Toast.LENGTH_LONG).show()

                    }
                }
                val currentTotal =data?.get(0)?.deposit?.minus(amountMoney + 2050)
                    val user = if (currentTotal != null) User(
                        amountMoney,
                        currentTotal,
                        "Withdraw",2050
                    ) else null
                    //adding the new balance to the db
                    if (user != null) db?.insertData(user)
                    tv.text = currentTotal.toString()
                    Toast.makeText(activity, currentTotal?.toString(), Toast.LENGTH_LONG).show()

            } else {
                editAmount.error = "please the amount to withdraw"
            }
            val data1 = db?.readData()
            tvResult.text = ""
            for (i in 0 until data1?.size!!) {
                tvResult.append(
                    "You made " + data1[i].transactionType + " transaction of amount " + data1[i].withdraw + " your current balance is "  + data1[i].deposit + " your withdraw charges are "  + data1[i].withdraw_charges + "\n\n\n"
                )
            }
        }

        btnDeposit.setOnClickListener {
            val data = db?.lastItem()
            if (editAmount.text.toString().isNotEmpty()) {
                //adding the deposited amount to the old balance in the db

                val currentTotal =
                    data?.get(0)?.deposit?.plus(editAmount.text.toString().toInt())

                val user = User(0, currentTotal!!, "Deposit",200)

                //adding the new balance to the db
                db.insertData(user)

                //displaying the current balance onDepositing the activity
                tv.text = currentTotal.toString()
                Toast.makeText(activity, currentTotal.toString(), Toast.LENGTH_LONG).show()

            } else {
                editAmount.error = "please the amount to Deposit"
            }
            val data1 = db?.readData()
            tvResult.text = ""
            for (i in 0 until data1?.size!!) {
                tvResult.append(
                    "You made " + data1[i].transactionType + " transaction of amount " + data1[i].withdraw + " your current balance " + data1[i].deposit + "\n\n\n"
                )
            }
        }

        return v

    }


}