package com.juandiegogarcia.chatbootapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.juandiegogarcia.chatbootapp.data.Message
import com.juandiegogarcia.chatbootapp.data.MessageRepository
import com.juandiegogarcia.chatbootapp.data.User
import com.juandiegogarcia.chatbootapp.data.UserRepository
import kotlinx.coroutines.launch
import com.juandiegogarcia.chatbootapp.data.Result
import java.time.Instant


class MessageViewModel : ViewModel() {

    private val _messages = MutableLiveData<List<Message>>()
    val messages: LiveData<List<Message>> get() = _messages


    private val _roomId = MutableLiveData<String>()
    private val _currentUser = MutableLiveData<User>()
    val currentUser: LiveData<User> get() = _currentUser

    private val messageRepository: MessageRepository
    private val userRepository: UserRepository
    init {
        messageRepository = MessageRepository(UserRepository.Injection.instance())
        userRepository = UserRepository(
            FirebaseAuth.getInstance(),
            UserRepository.Injection.instance()
        )
        loadCurrentUser()
    }

    private fun loadCurrentUser() {
        viewModelScope.launch {
            when (val result = userRepository.getCurrentUser()) {
                is Result.Success -> _currentUser.value = result.data
                is Error -> {
                    // Handle error, e.g., show a snackbar or log the error
                }
                // Agrega la siguiente línea para hacer el bloque when exhaustivo
                else -> {
                    // Manejar cualquier otro caso si es necesario
                }
            }
        }
    }



    fun loadMessages() {
        viewModelScope.launch {
            if (_roomId != null) {
                messageRepository.getChatMessages(_roomId.value.toString())
                    .collect { _messages.value = it }
            }
        }
    }

    fun sendMessage(text: String) {
        if (_currentUser.value != null) {
            val isSentByCurrentUser = _currentUser.value!!.email == _roomId.value
            val message = Message(
                senderFirstName = _currentUser.value!!.firstName,
                senderId = _currentUser.value!!.email,
                text = text,
                timestamp = System.currentTimeMillis(),
                isSentByCurrentUser = isSentByCurrentUser
            )
            viewModelScope.launch {
                when (val result = messageRepository.sendMessage(_roomId.value.toString(), message)) {
                    is Result.Success -> Unit
                    is Result.Error -> {
                        // Manejar el error aquí, por ejemplo, mostrar un mensaje de error
                    }
                }
            }
        }
    }



    fun setRoomId(roomId: String) {
        _roomId.value = roomId
        loadMessages()
    }

}

