package com.example.quizkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomAdapter(val resultQuiz:List<Question>):BaseAdapter() {
    override fun getCount(): Int {
        return resultQuiz.size
    }

    override fun getItem(position: Int): Any {
        return resultQuiz[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater:LayoutInflater=parent?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var rowView=convertView // la conventView ricicla
        if(rowView==null) { // se non trova vista già creata la crea da zero
            rowView = inflater.inflate(R.layout.final_report_cell,parent,false)
        }
        val testoDomanda = rowView!!.findViewById<TextView>(R.id.testoDomanda)
        val testoRisultato = rowView!!.findViewById<TextView>(R.id.testoRisultato)
        //testoDomanda.text=Questionario.questions[position].questionText
        testoDomanda.text=resultQuiz[position].questionText
        //testoRisultato.text=Questionario.questions[position].userAnswer.toString()
        testoRisultato.text=resultQuiz[position].userAnswer.toString()
        return rowView
    }
}