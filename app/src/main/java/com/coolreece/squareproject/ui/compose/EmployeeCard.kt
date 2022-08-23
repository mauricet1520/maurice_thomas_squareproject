package com.coolreece.squareproject.ui.compose

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.coolreece.squareproject.data.Employee
import com.coolreece.squareproject.data.EmployeeViewModel

@Composable
fun EmployeeCard(employee: Employee, navController: NavController, employeeViewModel: EmployeeViewModel ) {

    val painter =
        rememberImagePainter(data = employee.photoUrlSmall)

    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondaryVariant, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))


//        var isExpanded by remember { mutableStateOf(false) }
//        val surfaceColor by animateColorAsState(
//            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
//        )

        Column(modifier = Modifier.clickable {
           employeeViewModel.selectedEmployee = employee
            navController.navigate("employeedetailview")
        }) {
            Text(
                text = employee.fullName!!,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {

                Text(
                    text = employee.biography!!,
                    modifier = Modifier.padding(all = 4.dp),

                )
            }
        }
    }
}
