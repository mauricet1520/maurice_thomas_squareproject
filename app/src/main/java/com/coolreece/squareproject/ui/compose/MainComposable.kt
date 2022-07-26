package com.coolreece.squareproject.ui.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.coolreece.squareproject.R
import com.coolreece.squareproject.data.EmployeeViewModel


@Composable
fun MainDisplay(employeeViewModel: EmployeeViewModel = viewModel()) {
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
            EmployeeList(employeeViewModel)
        }
    )
}


