package com.juandiegogarcia.mywishapp.data

import kotlinx.coroutines.flow.Flow
import kotlin.collections.List as List

class WishRepository (private val wishDao: WishDao){
    suspend fun addWish(wish: Wish){
        wishDao.addWish(wish)
    }
    fun getWishes(): Flow<List<Wish>> = wishDao.getAllWishes()

    fun getAWishById(id:Long) : Flow<Wish>{
        return wishDao.getAWishesById(id)
    }

    suspend fun updateAWish(wish: Wish){
        wishDao.updateWish(wish)
    }

    suspend fun deleteAWish(wish: Wish){
        wishDao.deleteWish(wish)
    }
}