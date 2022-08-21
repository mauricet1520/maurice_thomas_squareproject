package com.coolreece.squareproject.data

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.coolreece.squareproject.util.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

open class EmployeeRepository(val app: Application) {

    val employeeData = MutableLiveData(listOf<Employee>())

    init {
        CoroutineScope(Dispatchers.IO).launch {
            withTimeout(130000L) {
                callEmployeeService()
            }
            Log.i("EmployeeService", "Calling EmployeeService in Repository")
        }
    }

    fun getEmployees() {
        employeeData.postValue(emptyList())
        CoroutineScope(Dispatchers.IO).launch {
            withTimeout(130000L) {
                callEmployeeService()
            }
            Log.i("EmployeeService", "Calling EmployeeService in Repository")
        }
    }

    @WorkerThread
    suspend fun callEmployeeService() {
        if (networkAvailable()) {
            val gson = GsonBuilder()
                .setLenient()
                .setPrettyPrinting()
                .create()

            val retrofit = buildRetrofit(gson)

            val service = retrofit.create(EmployeeService::class.java)
            val employeeServiceResponse = service.getEmployees()
            Log.i(
                "EmployeeService",
                "Calling EmployeeService ${employeeServiceResponse.isSuccessful} Body: ${employeeServiceResponse.body()}"
            )
            Log.i("EmployeeService", "Code ${employeeServiceResponse.code()}")

            val employees = employeeServiceResponse.body()?.employees ?: emptyList()
            validateEmployee(employees)
        } else {
            Log.i("Service", "Error No Network")
        }

    }

    private fun validateEmployee(employees: List<Employee>) {
        try {
            for (employee in employees) {
                if (employee.uuid == null) {
                    throw Throwable()
                } else if (employee.fullName == null) {
                    throw Throwable()
                } else if (employee.emailAddress == null) {
                    throw Throwable()
                } else if (employee.team == null) {
                    throw Throwable()
                } else if (employee.employeeType == null) {
                    throw Throwable()
                } else {
                    employeeData.postValue(employees)
                }
            }
        } catch (e: Throwable) {
            employeeData.postValue(emptyList())
        }
    }


    @Suppress("DEPRECATION")
    fun networkAvailable(): Boolean {
        Log.i("EmployeeService", "Checking Network}")

        val connectivityManager =
            app.getSystemService(
                Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo?.isConnectedOrConnecting ?: false
    }

    private fun buildRetrofit(gson: Gson?): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create()) //important
            .addConverterFactory(GsonConverterFactory.create(gson!!))
            .build()
    }

}