package com.juandiegogarcia.inheritanceapp

open class SecondaryClass : BaseClass() {

    override fun role() {
        super.role()
        println("Knight of the house of BaseClass")
    }
}