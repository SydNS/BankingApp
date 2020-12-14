package com.example.bankingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Transactions : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.transactions, container, false)
        //getting recyclerview from xml
        //getting recyclerview from xml
        val recyclerView = v.findViewById(R.id.recyclerView) as RecyclerView

        //adding a layoutmanager
        recyclerView.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)


        val transactionsmade = ArrayList<User>()
        val context = activity
        val db = context?.let { DataBaseHandler(it) }

        val data = db?.readData()

        for (i in 0 until data?.size!!) {
            transactionsmade.add(
                User(
                    data[i].withdraw,
                    data[i].deposit,
                    data[i].transactionType.toString(),
                    data[i].withdraw_charges
                )
            )
        }
        //creating our adapter
        val adapter = CustomAdapter(transactionsmade)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter
        return v


    }

}
