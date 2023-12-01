package com.juandiegogarcia.inheritanceapp

fun main() {
    val obj1 = BaseClass()
    obj1.coreValues()

    val obj2 = SecondaryClass()
    obj2.role()

    val obj3 = Tertiary()
    obj3.role()

    val frank = Offspring()
    frank.archery()
    frank.role()
    frank.coreValues()
    frank.sing()
}