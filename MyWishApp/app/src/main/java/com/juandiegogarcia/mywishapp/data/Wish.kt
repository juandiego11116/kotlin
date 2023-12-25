package com.juandiegogarcia.mywishapp.data

import android.icu.text.CaseMap.Title
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "wish-title")
    val title: String = "",
    @ColumnInfo(name = "wish-desc")
    val description: String = ""
)

object DummyWish{
    val wishList = listOf(
        Wish(title = "Google watch 2", description = "An android Watch"),
        Wish(title = "Apple 15 pro max", description = "An apple phone"),
        Wish(title = "New job as a develop", description = "Working as a mobile developer"),
        Wish(title = "Pay my debts", description = "Pay all of my debts "),
    )
}