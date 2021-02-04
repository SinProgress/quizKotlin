package com.example.quizkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.children

class QuestionFragment : Fragment() {
    lateinit var questionText: TextView
    lateinit var answersGroup : RadioGroup
    var punteggio = 0
    lateinit var sendAnswerButton: Button
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var currentIndex=0
        var currentQuestion=Questionario.questions[currentIndex]
        val v = inflater.inflate(R.layout.fragment_question, container, false)
        questionText=v.findViewById(R.id.questionText)
        answersGroup=v.findViewById(R.id.answers)
        sendAnswerButton=v.findViewById(R.id.confirmBtn)
        questionText.text=currentQuestion.question
        answersGroup.children.forEachIndexed{ //vado a prendere i figli radioGroup e su ognuno faccio una azione e so l'indice
            index, button ->
            button as RadioButton
            button.text=currentQuestion.options[index]
        }
        sendAnswerButton.setOnClickListener {  //bisogna fare una funzione che faccia questo
            val selected = answersGroup.checkedRadioButtonId
            val selectedButton= answersGroup.findViewById<RadioButton>(selected)
            val rightAnswer = currentQuestion.options[currentQuestion.answer]
          //  val pos = answersGroup.indexOfChild(selectedButton)
           // if (pos==currentQuestion.answer)
            if (selectedButton.text==rightAnswer){
                punteggio++
                Toast.makeText(this.context,"bravo, hai azzeccato!",Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this.context,"caprone, hai sbagliato!",Toast.LENGTH_LONG).show()
            }
            currentIndex++

        }
        return v
    }

}