package com.coolreece.squareproject.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class EmployeeViewModel(app: Application): AndroidViewModel(app) {

    private val employeeRepository = EmployeeRepository(app)

    var selectedEmployee : Employee? = null

    val employeeData: LiveData<List<Employee>> = employeeRepository.employeeData

    fun getEmployees() {
        Log.i("EmployeeService", " Calling getEmployees from ViewModel")
        employeeRepository.getEmployees()
    }

}