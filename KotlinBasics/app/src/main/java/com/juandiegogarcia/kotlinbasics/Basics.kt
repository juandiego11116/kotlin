package com.juandiegogarcia.kotlinbasics

fun main(){
    /*var myAge : Int
    val floatNumber = 23.3F
    val doubleNumber = 2304.0
    var age: UShort = 35u
    val myChar = 'a'
    val myString: String = "kidjsfn"
    var name = "Juan"
    val myTrue: Boolean = true
    println("Enter your age as a full number:")
    var enteredValue = readln()
    myAge =  enteredValue.toInt()
    if (myAge >= 18){
         println("You can go into the club")
    }else{
             println("You cannot go into the club")
    }
    var count = 0
    while (count < 3){
        println("Count is $count")
        count++
    }*/

    var numbers = arrayListOf(1.0, 2.0, 3.0, 4.0, 5.0)
    var sum = 0.0
    var average = 0.0
    for (number in numbers){
        sum += number
    }
    average = sum / numbers.size

    println("Avarage is " + average)


}