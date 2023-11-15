package com.juandiegogarcia.kotlinbasics

fun main() {
    print("Enter your age as a whole number: ")
    var age = readln()
    if (age.toInt() in 18..39){
        println("You can enter the club.")
    } else if (age.toInt() >= 40){
        println("You cannot go into the club, please go home.")
    } else {
        println("Age not verified. Please contact support.")
    }
}