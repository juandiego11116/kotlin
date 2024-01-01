package com.juandiegogarcia.musicappui

import androidx.annotation.DrawableRes

data class Library(@DrawableRes val icon: Int, val name: String)

val libraries = listOf<Library>(
    Library(R.drawable.baseline_queue_music_24, "PlayList"),
    Library(R.drawable.baseline_headset_mic_24,"Artists"),
    Library(R.drawable.baseline_disc_full_24, "Album"),
    Library(R.drawable.baseline_music_note_24, "Songs"),
    Library(R.drawable.baseline_music_video_24, "Genre"),
)
