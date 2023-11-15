package com.juandiegogarcia.kotlinbasics

import java.security.cert.TrustAnchor

fun main() {
    var myTrue: Boolean = true
    var myFalse: Boolean = false

    println(myTrue || myFalse) // true
    println(myTrue && myFalse) // false
    println(!myFalse) // true
}