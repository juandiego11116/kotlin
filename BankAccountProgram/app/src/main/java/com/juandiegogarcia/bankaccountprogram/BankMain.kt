package com.juandiegogarcia.bankaccountprogram

fun main() {
     val juanBankAccount = BankAccount("Juan Garcia", 123.2)
    juanBankAccount.deposit(4231.2)
    juanBankAccount.withdraw(234.4)
    juanBankAccount.displayTransactionHistory()
    println("${juanBankAccount.accountHolder}'s balance is ${juanBankAccount.acctBalance()}")
    val saraBankAccount = BankAccount("Sarah", 0.0)
    saraBankAccount.deposit(100.0)
    saraBankAccount.withdraw(10.0)
    saraBankAccount.deposit(300.0)
    saraBankAccount.displayTransactionHistory()
    println("${saraBankAccount.accountHolder}'s current balance using the ${saraBankAccount.acctBalance()}")
}