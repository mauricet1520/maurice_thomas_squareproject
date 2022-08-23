package com.coolreece.squareproject.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.coolreece.squareproject.data.Employee


@Composable
fun EmployeeDetailView(employee: Employee) {

    val painter =
        rememberImagePainter(data = employee.photoUrlLarge)

    Row(modifier = Modifier.padding(all = 8.dp)) {


        Column() {
            Image(
                painter = painter,
                contentDescription = null,
               Modifier.size(200.dp)
            )
            Text(text = employee.fullName!!)
            Text(text = employee.fullName!!)

        }
    }

}