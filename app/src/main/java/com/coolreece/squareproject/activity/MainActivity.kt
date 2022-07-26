package com.coolreece.squareproject.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.coolreece.squareproject.data.EmployeeViewModel
import com.coolreece.squareproject.ui.compose.MainDisplay
import com.coolreece.squareproject.ui.theme.SquareProjectTheme

class MainActivity : ComponentActivity() {

    private lateinit var employeeViewModel: EmployeeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        employeeViewModel = ViewModelProvider(this).get(EmployeeViewModel::class.java)

        setContent {
            SquareProjectTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "maindisplay"
                ) {
                    composable("maindisplay") {
                        MainDisplay(employeeViewModel)
                    }
                }
            }
        }
    }
}




