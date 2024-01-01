package com.juandiegogarcia.chatbootapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.juandiegogarcia.chatbootapp.data.Result
import com.juandiegogarcia.chatbootapp.data.UserRepository
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val userRepository: UserRepository
    private val _authResult = MutableLiveData<Result<Boolean>>()

    val authResult: MutableLiveData<Result<Boolean>> get() = _authResult

    object Injection {
        private val instance: FirebaseFirestore by lazy {
            FirebaseFirestore.getInstance()
        }

        fun instance(): FirebaseFirestore {
            return instance
        }
    }
    init {
        userRepository = UserRepository(
            FirebaseAuth.getInstance(),
            Injection.instance()
        )
    }



    fun signUp(email: String, password: String, firstName: String, lastName: String) {
        viewModelScope.launch {
            _authResult.value = userRepository.signUp(email, password, firstName, lastName)
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _authResult.value = userRepository.login(email, password)
        }
    }
}