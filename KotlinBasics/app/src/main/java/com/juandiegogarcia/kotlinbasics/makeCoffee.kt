package com.juandiegogarcia.kotlinbasics

fun main() {
    //Immutable List
    val shoppingList = listOf("Processor", "RAM", "Graphics Card", "SSD")

    val shoppingList2 = mutableListOf("Processor", "RAM", "Graphics Card", "SSD")

    println(shoppingList[2])

    shoppingList2.add("Cooling System")
    shoppingList2.set(1,"Ram")
    val hasRam = shoppingList2.contains("Ram")
    if(shoppingList2.contains("Ram")){
        println("Has Ram in the list")
    }else{
        println("No Ram in the list")
    }

    for(item in shoppingList2){

        println(item)
    }

    for(item in 0 .. shoppingList2.size){

        if (shoppingList2[item] == "Ram"){
            println(shoppingList[item])
        }

        println(item)
    }
}

/*
data class coffeeDetails(
    val sugarCount: Int,
    val name: String,
    val size: String,
    val creamAmount: Int
)
fun main() {
    makeCoffee(0, "Juan")
    println("Enter first number")
    var userNumber1 = readln()
    println("Enter second number")
    var userNumber2 = readln()
    val num1 = userNumber1.toInt()
    val num2 = userNumber2.toInt()
    val result = add(num1, num2)
    println("Result to add is $result")
}
 fun add(number1: Int, number2: Int): Int {
     val result = number1 + number2
     return result
 }
fun makeCoffee(sugarCount: Int, name: String){
    if (sugarCount == 0){
        println("Coffee with no sugar for $name")
    } else if (sugarCount == 1){
        println("Coffee with 1 spoon of sugar for $name")
    }else{
        println("Coffee with $sugarCount spoons of sugar $name")
    }
}*/