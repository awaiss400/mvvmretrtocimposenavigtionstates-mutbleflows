package com.stone.retromvvmgenerics.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(
    val route:String,
    val title:String,
    val icon:ImageVector){
     object Home: Screens("home","Home", Icons.Filled.Home)
     object Profile: Screens("profile","Profile", Icons.Filled.Person)

}
