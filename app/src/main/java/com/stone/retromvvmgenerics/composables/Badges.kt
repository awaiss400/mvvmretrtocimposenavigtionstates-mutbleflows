package com.stone.retromvvmgenerics

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun BottomBar(navController: NavHostController,viewModel: Myviewmodel) {
    NavHost(navController=navController, startDestination = "home"){
        composable("home"){
HomeScreen(viewModel = viewModel)

        }
        composable("profile"){
DataScren(viewModel = viewModel, navController =navController )
        }

    }
}




