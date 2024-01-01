package com.juandiegogarcia.chatbootapp.data

data class Message(
    val text: String,
    val timestamp: Long,
    val senderId: String,
    val senderFirstName: String,
    val isSentByCurrentUser: Boolean
)
