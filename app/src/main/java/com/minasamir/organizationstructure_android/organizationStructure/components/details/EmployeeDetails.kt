package com.minasamir.organizationstructure_android.organizationStructure.components.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.minasamir.organizationstructure_android.organizationStructure.EmployeeUiModel
import com.minasamir.organizationstructure_android.organizationStructure.complexEmployees
import com.minasamir.organizationstructure_android.ui.theme.OrganizationStructureAndroidTheme

@Composable
fun EmployeeDetails(
    employee: EmployeeUiModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = employee.name
        )

        EmployeeDescriptionItem(
            description = employee.position,
            icon = Icons.Default.Person
        )
        EmployeeDescriptionItem(
            description = employee.position,
            icon = Icons.Default.LocationOn
        )
    }
}

@Composable
@Preview
private fun EmployeeDetailsPreview() {
    OrganizationStructureAndroidTheme {
        EmployeeDetails(complexEmployees.first())
    }
}