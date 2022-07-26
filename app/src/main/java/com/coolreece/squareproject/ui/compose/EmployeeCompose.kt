package com.coolreece.squareproject.ui.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.coolreece.squareproject.data.EmployeeViewModel

@Composable
fun EmployeeList(employeeViewModel: EmployeeViewModel = viewModel()) {

    val employees = employeeViewModel.employeeData.observeAsState()

    if (employees.value!!.isNotEmpty()) {
        LazyColumn {
            items(employees.value!!) { employee ->
                EmployeeCard(employee = employee)
            }
        }
    } else {
        Text(text = "No Employee Data listed")
    }

}