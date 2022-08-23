package com.coolreece.squareproject.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EmployeeDao {

    @Query("SELECT * FROM employees")
    fun getAll(): List<Employee>

    @Insert
    suspend fun insertGame(employee: Employee)

    @Insert
    suspend fun insertEmployees(games: List<Employee>)

    @Query("DELETE FROM employees")
    suspend fun deleteAll()
}