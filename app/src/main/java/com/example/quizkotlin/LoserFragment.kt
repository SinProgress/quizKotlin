package com.example.quizkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import androidx.navigation.Navigation

class LoserFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v=inflater.inflate(R.layout.fragment_loser, container, false)
        val RButton=v.findViewById<Button>(R.id.reTryButton)
        val report=v.findViewById<ListView>(R.id.checkLoserRisultati) //passo listView
        val adapter=CustomAdapter(Questionario.questions) // creo adapter
        report.adapter=adapter

        RButton.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_loserFragment_to_startFragment)
        )
        return v
    }

}