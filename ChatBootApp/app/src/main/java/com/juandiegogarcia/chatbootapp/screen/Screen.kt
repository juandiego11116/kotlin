package com.juandiegogarcia.chatbootapp.screen

sealed class Screen(val route:String){
    object LoginScreen:Screen("loginscreen")
    object SignupScreen:Screen("signupscreen")
    object ChatRoomsScreen:Screen("chatroomscreen")
    object ChatScreen:Screen("chatscreen")
}