package com.coolreece.squareproject.ui.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.coolreece.squareproject.R
import com.coolreece.squareproject.data.EmployeeViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainDisplay(employeeViewModel: EmployeeViewModel = viewModel(), navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.app_bar_title)) },
                actions = {

                    IconButton(onClick = {
                        employeeViewModel.getEmployees()
                    }) {
                        Row {
                            Icon(Icons.Filled.Refresh, contentDescription = "Refresh")
                        }
                    }
                }

            )
        },
        content = {
            EmployeeList(employeeViewModel, navController, employeeViewModel)
        }
    )
}


