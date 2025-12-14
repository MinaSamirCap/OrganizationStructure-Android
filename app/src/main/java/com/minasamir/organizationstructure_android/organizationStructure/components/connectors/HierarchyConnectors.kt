package com.minasamir.organizationstructure_android.organizationStructure.components.connectors

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.minasamir.organizationstructure_android.organizationStructure.EmployeeUiModel
import com.minasamir.organizationstructure_android.organizationStructure.complexEmployees
import com.minasamir.organizationstructure_android.organizationStructure.components.badge.EmployeeBadge
import com.minasamir.organizationstructure_android.organizationStructure.iterateAndChange
import com.minasamir.organizationstructure_android.ui.theme.OrganizationStructureAndroidTheme

@Composable
fun HierarchyConnectors(
    depth: Int,
    isLastChild: Boolean,
    employee: EmployeeUiModel
) {

    var currentDepth = 0
    Row {
        for (i in 0 until depth) {
            currentDepth++
            Box {
                // draw horizontal line according to the condition ...
                // draw horizontal line or not ....
                if (depth - currentDepth == 0) {
                    Box(
                        modifier = Modifier
                            .size(34.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        ConnectorHorizontalLine(
                            modifier = Modifier
                                .height(1.dp)
                                .width(34.dp)
                        )
                    }
                }

                // draw vertical line according to the conditions ...
                // when to draw full vertical line or till half of badge ....
                if (isLastChild && (depth - currentDepth == 0)) {
                    // draw till half of badge
                    Box(
                        modifier = Modifier
                            .width(34.dp), // 34 is the badge size
                        contentAlignment = Alignment.Center
                    ) {
                        ConnectorVerticalLine(
                            modifier = Modifier
                                .width(1.dp)
                                .height(16.dp) // 16 is the half of the badge size
                        )
                    }
                    iterateAndChange(employee, depth - 1)

                } else {
                    // draw full vertical line
                    Box(
                        modifier = Modifier
                            .width(34.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        if (!employee.doNotDraw.contains(i)) {
                            ConnectorVerticalLine(
                                modifier = Modifier
                                    .width(1.dp)
                                    .height(80.dp)
                            )
                        }
                    }
                }

            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            EmployeeBadge(
                employee = employee
            )
            // to draw under the badge or not ....
            if (employee.children.isNotEmpty()) {
                ConnectorVerticalLine(
                    modifier = Modifier
                        .width(1.dp)
                        .height(40.dp)
                )
            }
        }
    }
}

@Composable
@Preview
private fun HierarchyConnectorsPreview() {
    OrganizationStructureAndroidTheme {
        Column {
            HierarchyConnectors(
                depth = 0,
                isLastChild = false,
                employee = complexEmployees.first()
            )

            HierarchyConnectors(
                depth = 1,
                isLastChild = false,
                employee = complexEmployees.first()
            )

            HierarchyConnectors(
                depth = 2,
                isLastChild = false,
                employee = complexEmployees.first()
            )
        }
    }
}


@Composable
@Preview(locale = "ar")
private fun HierarchyConnectorsArPreview() {
    OrganizationStructureAndroidTheme {
        Column {
            HierarchyConnectors(
                depth = 0,
                isLastChild = false,
                employee = complexEmployees.first()
            )

            HierarchyConnectors(
                depth = 1,
                isLastChild = false,
                employee = complexEmployees.first()
            )

            HierarchyConnectors(
                depth = 2,
                isLastChild = false,
                employee = complexEmployees.first()
            )
        }
    }
}