package com.juandiegogarcia.rockpaperscissors

fun main() {
    var computerChoice = ""
    var playerChoice = ""
    println("Rock, Paper or Scissors? Enter ypur choice!")
    playerChoice = readln()

    while (playerChoice == "Rock" || playerChoice == "Paper" ||playerChoice == "Scissors"){
        var randomNumber = (1..3).random()

        when (randomNumber) {
            1 -> {
                computerChoice = "Rock"
            }
            2 -> {
                computerChoice = "Paper"
            }
            3 -> {
                computerChoice = "Scissors"
            }
        }
        println(computerChoice)
        val winner = when {
            playerChoice == computerChoice -> "Tie"
            playerChoice == "Rock" && computerChoice == "Scissors" -> "Player"
            playerChoice == "Paper" && computerChoice == "Rock" -> "Player"
            playerChoice == "Scissors" && computerChoice == "Paper" -> "Player"
            else -> "Computer"
        }

        when (winner) {
            "Tie" -> {
                println("It's tie")
            }
            else -> {
                println("$winner won!")
            }
        }
        println("Rock, Paper or Scissors? Enter ypur choice!")
        playerChoice = readln()
    }
}