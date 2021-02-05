package com.example.quizkotlin

class Question(val questionText: String, val options:List<String>, val answer:Int, var userAnswer: Answered=Answered.NONE) {
}