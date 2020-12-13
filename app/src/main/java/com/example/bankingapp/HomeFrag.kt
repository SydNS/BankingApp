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
import com.example.bankingapp.User

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
//        val btnRead = v.findViewById<Button>(R.id.btnRead)
        val btnDeposit = v.findViewById<Button>(R.id.btnDeposit)
        val tvResult = v.findViewById<TextView>(R.id.tvResult)
        val editAmount = v.findViewById<EditText>(R.id.amount)

        //displaying the current balance onresuming the activity
        val dataOnresume = db?.lastItem()
        if (!dataOnresume.isNullOrEmpty()) {
            val lastBalance = dataOnresume!![0].deposit.toString()
            tv.text = lastBalance
        }


        btnWithdraw.setOnClickListener {
            val data = db?.lastItem()
            if (editAmount.text.toString().isNotEmpty()) {
                //adding the deposited amount to the old balance in the db
                val amountMoney = editAmount.text.toString().toInt()
                if (amountMoney in 500..2500) {
                    val currentTotal =
                        data?.get(0)?.deposit?.minus(amountMoney + 200)
                    val user = currentTotal?.let { it1 ->
                        User(
                            amountMoney,
                            it1,
                            "Withdraw"
                        )
                    }

                    //adding the new balance to the db
                    if (user != null) db?.insertData(user)
                    tv.text = currentTotal.toString()
                    Toast.makeText(activity, currentTotal?.toString(), Toast.LENGTH_LONG).show()


                }
                //displaying the current balance onDepositing the activity

            } else {
                editAmount.error = "please the amount to withdraw"
            }
            val data1 = db?.readData()
            tvResult.text = ""
            for (i in 0 until data1?.size!!) {
                tvResult.append(
                    "You made " + data1[i].transactionType + " transaction of amount " + data1[i].withdraw + " your current balance " + data1[i].deposit + "\n\n\n"
                )
            }
        }

        btnDeposit.setOnClickListener {
            val data = db?.lastItem()
            if (editAmount.text.toString().isNotEmpty()) {
                //adding the deposited amount to the old balance in the db

                val currentTotal =
                    data?.get(0)?.deposit?.plus(editAmount.text.toString().toInt())

                val user = User(0, currentTotal!!, "Deposit")

                //adding the new balance to the db
                if (user != null) db.insertData(user)

                //displaying the current balance onDepositing the activity
                tv.text = currentTotal.toString()
                Toast.makeText(activity, currentTotal?.toString(), Toast.LENGTH_LONG).show()

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

    private val context = activity
    private val db = context?.let { DataBaseHandler(it) }
    private val data = db?.lastItem()

//    fun bankCharging(amountMoney: Int) {
//        if (2500 <= amountMoney && amountMoney >= 500) {
//            val currentTotal =
//                data?.get(0)?.deposit?.minus(amountMoney+200)
//            val user = currentTotal?.let { it1 ->
//                User(
//                    amountMoney,
//                    it1,
//                    "Withdraw"
//                )
//            }

    //adding the new balance to the db
//            if (user != null) db?.insertData(user)
//            tv.text = currentTotal.toString()
//            Toast.makeText(activity, currentTotal?.toString(), Toast.LENGTH_LONG).show()
//
//
//        } else if (2500 <= amountMoney && amountMoney >= 500) {
//        } else if (5000 <= amountMoney && amountMoney >= 2501) {
//        } else if (15000 <= amountMoney && amountMoney >= 5001) {
//        } else if (30000 <= amountMoney && amountMoney >= 15001) {
//        } else if (45000 <= amountMoney && amountMoney >= 30001) {
//        } else if (60000 <= amountMoney && amountMoney >= 45001) {
//        } else if (125000 <= amountMoney && amountMoney >= 60001) {
//        } else if (250000 <= amountMoney && amountMoney >= 125001) {
//        } else if (500000 <= amountMoney && amountMoney >= 250001) {
//        }
//
//    }
}