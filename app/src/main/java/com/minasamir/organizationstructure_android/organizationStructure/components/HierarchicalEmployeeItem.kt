package com.minasamir.organizationstructure_android.organizationStructure.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.minasamir.organizationstructure_android.organizationStructure.EmployeeUiModel
import com.minasamir.organizationstructure_android.organizationStructure.complexEmployees
import com.minasamir.organizationstructure_android.organizationStructure.components.details.EmployeeDetails
import com.minasamir.organizationstructure_android.ui.theme.OrganizationStructureAndroidTheme

@Composable
fun HierarchicalEmployeeItem(
    employee: EmployeeUiModel,
    depth: Int,
    isLastInSiblingGroup: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        // Left column for hierarchy lines and badge
        HierarchyConnectorsColumn(
            depth = depth,
            isLastChild = isLastInSiblingGroup,
            employee = employee
        )

        Spacer(modifier = Modifier.width(12.dp))

        // Employee details column
        EmployeeDetails(employee = employee)
    }
}


@Composable
@Preview
private fun HierarchicalEmployeeItem0Preview() {
    OrganizationStructureAndroidTheme {
        HierarchicalEmployeeItem(
            depth = 0,
            employee = complexEmployees.first(),
            isLastInSiblingGroup = true
        )
    }
}


@Composable
@Preview
private fun HierarchicalEmployeeItem1Preview() {
    OrganizationStructureAndroidTheme {
        HierarchicalEmployeeItem(
            depth = 1,
            employee = complexEmployees.first(),
            isLastInSiblingGroup = false
        )
    }
}

@Composable
@Preview
private fun HierarchicalEmployeeItem2Preview() {
    OrganizationStructureAndroidTheme {
        HierarchicalEmployeeItem(
            depth = 2,
            employee = complexEmployees.first(),
            isLastInSiblingGroup = false
        )
    }
}