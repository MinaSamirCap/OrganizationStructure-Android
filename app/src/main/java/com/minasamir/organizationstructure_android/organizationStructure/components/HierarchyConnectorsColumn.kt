package com.minasamir.organizationstructure_android.organizationStructure.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.minasamir.organizationstructure_android.organizationStructure.EmployeeUiModel
import com.minasamir.organizationstructure_android.organizationStructure.complexEmployees
import com.minasamir.organizationstructure_android.organizationStructure.components.badge.EmployeeBadge
import com.minasamir.organizationstructure_android.organizationStructure.isRTL
import com.minasamir.organizationstructure_android.organizationStructure.iterateAndChange
import com.minasamir.organizationstructure_android.ui.theme.OrganizationStructureAndroidTheme

@Composable
fun HierarchyConnectorsColumn(
    depth: Int,
    isLastChild: Boolean,
    employee: EmployeeUiModel
) {

    var counter = 0
    val isRTL = isRTL()

    Row {
        for (i in 0 until depth) {
            counter++
            Box {

                // draw horizontal line or not ....
                if (depth - counter == 0) {
                    Box(
                        modifier = Modifier
                            .width(34.dp)
                            .height(34.dp),  // Changed from .width() to .height()
                        contentAlignment = Alignment.Center
                    ) {
                        Canvas(
                            modifier = Modifier
                                .height(1.dp)    // Changed from .width()
                                .width(80.dp)    // Changed from .height()
                        ) {
                            // HORIZONTAL line: Keep Y constant, change X
                            if (isRTL) {
                                drawLine(
                                    color = Color(0xFFCCCCCC),
                                    start = Offset(-size.width, size.height / 2),      // Child side
                                    end = Offset(size.width / 2, size.height / 2),
                                    strokeWidth = 1.dp.toPx(),
                                    pathEffect = PathEffect.dashPathEffect(
                                        floatArrayOf(15f, 10f),
                                        0f
                                    )
                                )
                            } else {
                                drawLine(
                                    color = Color(0xFFCCCCCC),
                                    start = Offset(
                                        size.width / 2,
                                        size.height / 2
                                    ),      // Left side, middle height
                                    end = Offset(
                                        size.width,
                                        size.height / 2
                                    ), // Right side, middle height
                                    strokeWidth = 1.dp.toPx(),
                                    pathEffect = PathEffect.dashPathEffect(
                                        floatArrayOf(15f, 10f),
                                        0f
                                    )
                                )
                            }


                        }
                    }
                }


                // when to draw full vertical line or half of it ....
                if (isLastChild && (depth - counter == 0)) {
                    // draw half of badge
                    Box(
                        modifier = Modifier
                            .width(34.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Canvas(
                            modifier = Modifier
                                .width(1.dp)
                                .height(16.dp)
                        ) {
                            drawLine(
                                color = Color(0xFFCCCCCC),
                                start = Offset(size.width / 2, 0f),
                                end = Offset(size.width / 2, size.height),
                                strokeWidth = 1.dp.toPx(),
                                pathEffect = PathEffect.dashPathEffect(
                                    floatArrayOf(15f, 10f),
                                    0f
                                )
                            )
                        }
                    }
                    iterateAndChange(employee, depth - 1)

                } else {
                    // draw full space
                    Box(
                        modifier = Modifier
                            .width(34.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Canvas(
                            modifier = Modifier
                                .width(1.dp)
                                .height(80.dp)
                        ) {
                            if (!employee.doNotDraw.contains(i)) {
                                drawLine(
                                    color = Color(0xFFCCCCCC),
                                    start = Offset(size.width / 2, 0f),
                                    end = Offset(size.width / 2, size.height),
                                    strokeWidth = 1.dp.toPx(),
                                    pathEffect = PathEffect.dashPathEffect(
                                        floatArrayOf(15f, 10f),
                                        0f
                                    )
                                )
                            }

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
                Canvas(
                    modifier = Modifier
                        .width(1.dp)
                        .height(40.dp)
                ) {
                    drawLine(
                        color = Color(0xFFCCCCCC),
                        start = Offset(size.width / 2, 0f),
                        end = Offset(size.width / 2, size.height),
                        strokeWidth = 1.dp.toPx(),
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(15f, 10f), 0f)
                    )
                }
            }
        }

    }
}

@Composable
@Preview
private fun HierarchyConnectorsColumnPreview() {
    OrganizationStructureAndroidTheme {
        Column {
            HierarchyConnectorsColumn(
                depth = 0,
                isLastChild = false,
                employee = complexEmployees.first()
            )

            HierarchyConnectorsColumn(
                depth = 1,
                isLastChild = false,
                employee = complexEmployees.first()
            )

            HierarchyConnectorsColumn(
                depth = 2,
                isLastChild = false,
                employee = complexEmployees.first()
            )
        }
    }
}


@Composable
@Preview(locale = "ar")
private fun HierarchyConnectorsColumnArPreview() {
    OrganizationStructureAndroidTheme {
        Column {
            HierarchyConnectorsColumn(
                depth = 0,
                isLastChild = false,
                employee = complexEmployees.first()
            )

            HierarchyConnectorsColumn(
                depth = 1,
                isLastChild = false,
                employee = complexEmployees.first()
            )

            HierarchyConnectorsColumn(
                depth = 2,
                isLastChild = false,
                employee = complexEmployees.first()
            )
        }
    }
}