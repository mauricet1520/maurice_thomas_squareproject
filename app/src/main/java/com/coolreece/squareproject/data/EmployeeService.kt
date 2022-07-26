package com.coolreece.squareproject.data

import retrofit2.Response
import retrofit2.http.GET

interface EmployeeService {
    @GET("/sq-mobile-interview/employees.json")
    suspend fun getEmployees(): Response<EmployeeDirectory>
}