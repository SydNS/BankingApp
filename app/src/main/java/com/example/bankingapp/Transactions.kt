package com.example.bankingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment

class Transactions: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.transactions, container, false)
//        val tv: TextView =v.findViewById(R.id.transactdets)
//        val tvTransacs: TextView =v.findViewById(R.id.tvTransacs)
//        tv.text="tftyjvytg"
//
//        val context = activity
//        val db = context?.let { DataBaseHandler(it) }
//
//        val data = db?.readData()
//        tvTransacs.text = ""
//        for (i in 0 until data?.size!!) {
//            tvTransacs.append(
//                " " + data[i].deposit + " " + data[i].withdraw + "\n"
//            )
//        }

        return v


    }

}
