package com.coolreece.squareproject.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "employees")
data class Employee(
    @PrimaryKey
    val uuid: String,
    @SerializedName("full_name")
    val fullName: String? = null,
    @SerializedName("phone_number")
    val phoneNumber: String,
    @SerializedName("email_address")
    val emailAddress: String? = null,
    val biography: String,
    @SerializedName("photo_url_small")
    val photoUrlSmall: String,
    @SerializedName("photo_url_large")
    val photoUrlLarge: String,
    val team: String? = null,
    @SerializedName("employee_type")
    val employeeType: String

)
