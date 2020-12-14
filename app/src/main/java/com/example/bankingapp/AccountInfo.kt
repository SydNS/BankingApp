package com.example.bankingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class AccountInfo : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val v: View = inflater.inflate(R.layout.fragment_accountinfo, container, false)

        (requireActivity() as Home).title = "DH Bank  Profile"

        val currentbal = v.findViewById(R.id.currentbalance) as TextView

        val context = activity
        val db = context?.let { DataBaseHandler(it) }
        val dataOnresume = db?.lastItem()
        if (!dataOnresume.isNullOrEmpty()) {
            val lastBalance = dataOnresume[0].deposit.toString()
            currentbal.text = lastBalance
        }

        return v


    }
}
