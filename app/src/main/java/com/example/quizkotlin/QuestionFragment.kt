package com.example.quizkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.children
import androidx.navigation.findNavController

class QuestionFragment : Fragment() {
    lateinit var questionText: TextView
    lateinit var answersGroup : RadioGroup
    //lateinit var currentQuestion : Question
    var punteggio = 0 //punteggio finale
    var currentIndex=0 // variabile con l'indice della domanda
    lateinit var sendAnswerButton: Button
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        //var currentQuestion=Questionario.questions[currentIndex]
        val v = inflater.inflate(R.layout.fragment_question, container, false)
        questionText=v.findViewById(R.id.questionText)
        answersGroup=v.findViewById(R.id.answers)
        sendAnswerButton=v.findViewById(R.id.confirmBtn)

        makeQuestion(currentIndex) //funzione che fa le domande

        sendAnswerButton.setOnClickListener {
            val selected = answersGroup.checkedRadioButtonId
            val selectedButton= answersGroup.findViewById<RadioButton>(selected)
            val currentQuestion = Questionario.questions[currentIndex]
            val rightAnswer = currentQuestion.options[currentQuestion.answer]
          //  val pos = answersGroup.indexOfChild(selectedButton)
           // if (pos==currentQuestion.answer)
            if (selectedButton.text==rightAnswer){
                punteggio++
                currentQuestion.userAnswer=Answered.RIGHT
               // Toast.makeText(this.context,"bravo, hai azzeccato!",Toast.LENGTH_LONG).show()
            } else {
                currentQuestion.userAnswer=Answered.WRONG
               // Toast.makeText(this.context,"caprone, hai sbagliato!",Toast.LENGTH_LONG).show()
            }
            currentIndex++
            if(currentIndex>=Questionario.questions.size){
                checkGame(v)
            } else {
                makeQuestion(currentIndex)
            }

        }
        return v
    }

    fun makeQuestion(currentIndex:Int){
        val currentQuestion=Questionario.questions[currentIndex]
        questionText.text=currentQuestion.questionText
        answersGroup.children.forEachIndexed{ //vado a prendere i figli radioGroup e su ognuno faccio una azione e so l'indice
            index, button ->
            button as RadioButton
            button.text=currentQuestion.options[index]
        }

    }
    fun checkGame(v:View){
        if (punteggio>=(Questionario.questions.size*2)/3){
            v.findNavController().navigate(R.id.action_questionFragment_to_winnerFragment)
        } else {
            v.findNavController().navigate(R.id.action_questionFragment_to_loserFragment)
        }

    }

}

