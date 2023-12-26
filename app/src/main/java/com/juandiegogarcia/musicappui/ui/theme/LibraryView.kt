package com.juandiegogarcia.musicappui.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.juandiegogarcia.musicappui.Library
import com.juandiegogarcia.musicappui.libraries

@Composable
fun LibraryView(){
    LazyColumn {
        items(libraries){
            lib ->
            LibItem(lib = lib)

        }
    }
}

@Composable
fun LibItem(lib: Library){
    Column {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
            ){
            Row {
                Icon(painter = painterResource(id = lib.icon), contentDescription = lib.name,
                    Modifier.padding(horizontal = 8.dp))
                Text(text = lib.name)
            }
            Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null)

        }
    }
}