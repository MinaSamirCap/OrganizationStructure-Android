package com.minasamir.organizationstructure_android.organizationStructure

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.minasamir.organizationstructure_android.organizationStructure.components.HierarchicalEmployeeItem
import com.minasamir.organizationstructure_android.ui.theme.OrganizationStructureAndroidTheme

@Composable
fun OrganizationStructure(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
    ) {
        // Use items directly with flat list
        items(flattenHierarchy(complexEmployees)) { employee ->
            HierarchicalEmployeeItem(
                employee = employee.item,
                depth = employee.depth,
                isLastInSiblingGroup = employee.isLastInSiblingGroup
            )
        }
    }
}

// Data class to hold flattened hierarchy info
private data class FlattenedEmployee(
    val item: EmployeeUiModel,
    val depth: Int,
    val isLastInSiblingGroup: Boolean
)

// Function to flatten hierarchy with depth information
private fun flattenHierarchy(
    employees: List<EmployeeUiModel>,
    depth: Int = 0
): List<FlattenedEmployee> {
    val result = mutableListOf<FlattenedEmployee>()

    employees.forEachIndexed { index, employee ->
        val isLast = index == employees.size - 1
        result.add(FlattenedEmployee(employee, depth, isLast))

        // Recursively add children
        if (employee.children.isNotEmpty()) {
            result.addAll(flattenHierarchy(employee.children, depth + 1))
        }
    }

    return result
}


@Composable
@Preview
private fun OrganizationStructurePreview() {
    OrganizationStructureAndroidTheme {
        OrganizationStructure()
    }
}

@Composable
@Preview(locale = "ar")
private fun OrganizationStructureArPreview() {
    OrganizationStructureAndroidTheme {
        OrganizationStructure()
    }
}