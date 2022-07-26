package com.coolreece.squareproject.data

import com.google.gson.annotations.SerializedName

data class Employee(
    val uuid: String? = null,
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
