package com.juandiegogarcia.chatbootapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juandiegogarcia.chatbootapp.data.Result
import com.juandiegogarcia.chatbootapp.data.Room
import com.juandiegogarcia.chatbootapp.data.RoomRepository
import com.juandiegogarcia.chatbootapp.data.UserRepository
import kotlinx.coroutines.launch

class RoomViewModel : ViewModel() {

    private val _rooms = MutableLiveData<List<Room>>()
    val rooms: LiveData<List<Room>> get() = _rooms
    private val roomRepository: RoomRepository
    init {
        roomRepository = RoomRepository(UserRepository.Injection.instance())
        loadRooms()
    }

    fun createRoom(name: String) {
        viewModelScope.launch {
            roomRepository.createRoom(name)
        }
    }

    fun loadRooms() {
        viewModelScope.launch {
            when (val result = roomRepository.getRooms()) {
                is Result.Success -> _rooms.value = result.data
                is Result.Error -> {

                }
            }
        }
    }

}