package com.example.quizkotlin

class Questionario() {
    companion object Data {
        val questions= mutableListOf(
            Question("Cos'è una classe?", listOf(
                "una questione di stile",
                "un social network",
                "un tipo di dato definito da stato e comportamento"
            ),2),
            Question("Cos'è il polimorfismo?", listOf(
                "un animale africano",
                "la capacità di un reference x di puntare ad un oggetto che implementa/estende x",
                "una pratica carnevalesca"
            ),1),
            Question("Perchè studiamo kotlin", listOf(
                "perchè java è superato per le app android",
                "mi piace come suona il nome",
                "per masochismo"
            ),0),
        )
    }
}