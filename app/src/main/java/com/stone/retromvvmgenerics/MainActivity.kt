package com.stone.retromvvmgenerics

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.stone.retromvvmgenerics.composables.BottomNAvItems
import com.stone.retromvvmgenerics.bottomNavAllinOne.BottomNavBar
import com.stone.retromvvmgenerics.ui.theme.RetroMvvmGenericsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<Myviewmodel>()
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                setContent {
                    val navController= rememberNavController()

                    RetroMvvmGenericsTheme(){
                        // A surface container using the 'background' color from the theme
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                        ) {
                            MainSc(navController = navController, viewModel =viewModel )
                        }
                    }
                }
            }
        }

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainSc(navController:NavController,viewModel:Myviewmodel) {


    Scaffold(bottomBar ={
        BottomNavBar(items = listOf(
            BottomNAvItems("Home", Icons.Default.Home,"home"),
            BottomNAvItems("Home", Icons.Default.Person,"profile"),
        ),
            navController =navController , onitemClick ={
                navController.navigate(it.route)
            } )
    } ) {
        BottomBar(viewModel = viewModel, navController = navController as NavHostController)
    }
//AlertDialogsBoxes()
//                DailogBx()

}