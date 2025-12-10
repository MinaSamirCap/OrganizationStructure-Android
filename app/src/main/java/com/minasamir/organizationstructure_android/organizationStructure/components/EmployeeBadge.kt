package com.minasamir.organizationstructure_android.organizationStructure.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.minasamir.organizationstructure_android.organizationStructure.EmployeeUiModel
import com.minasamir.organizationstructure_android.organizationStructure.complexEmployees
import com.minasamir.organizationstructure_android.ui.theme.OrganizationStructureAndroidTheme

@Composable
fun EmployeeBadge(
    employee: EmployeeUiModel,
    modifier: Modifier = Modifier
) {
    val initials = employee.name.split(" ")
        .take(2)
        .joinToString("") { it.firstOrNull()?.toString() ?: "" }
        .uppercase()

    Box(
        modifier = modifier
            .size(34.dp)
            .clip(CircleShape)
            .background(employee.color),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = initials,
            color = Color.White,
            fontWeight = FontWeight.W600,
            fontSize = 14.sp
        )
    }
}

@Composable
@Preview
private fun EmployeeBadgePreview() {
    OrganizationStructureAndroidTheme {
        EmployeeBadge(
            employee = complexEmployees.first()
        )
    }
}