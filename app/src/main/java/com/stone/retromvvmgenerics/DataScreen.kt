package com.stone.retromvvmgenerics

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.stone.retromvvmgenerics.APi.Posts
import com.stone.retromvvmgenerics.composables.Screens

@Composable
fun DataScren(viewModel: Myviewmodel,navController: NavController) {
    var text1 by remember {
        mutableStateOf("")
    }
    var text2 by remember {
        mutableStateOf("")
    }
Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
    TextField(value =text1 , onValueChange ={text1=it} )
    Spacer(modifier = Modifier.height(10.dp))
    TextField(value =text2 , onValueChange ={text2=it} )
    Button(onClick = {navController.navigate(Screens.Home.route)}) {
        Text(text = "watch data")
    }
    Button(onClick = { viewModel.post(Posts(1,455,"",""))}) {
        Text(text = "Post data")
    }

}


}