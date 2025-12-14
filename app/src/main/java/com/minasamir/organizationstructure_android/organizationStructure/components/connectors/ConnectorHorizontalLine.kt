package com.minasamir.organizationstructure_android.organizationStructure.components.connectors

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.minasamir.organizationstructure_android.organizationStructure.isRTL
import com.minasamir.organizationstructure_android.ui.theme.OrganizationStructureAndroidTheme

@Composable
fun ConnectorHorizontalLine(
    modifier: Modifier,
    color: Color = Color(0xFFCCCCCC)
) {
    val isRTL = isRTL()
    Canvas(
        modifier = modifier
    ) {
        if (isRTL) {
            drawLine(
                color = color,
                start = Offset(-size.width, size.height / 2),      // Child side
                end = Offset(size.width / 2, size.height / 2),
                strokeWidth = 1.dp.toPx(),
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(15f, 10f), 0f)
            )
        } else {
            drawLine(
                color = color,
                start = Offset(size.width / 2, size.height / 2),
                end = Offset(size.width, size.height / 2),
                strokeWidth = 1.dp.toPx(),
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(15f, 10f), 0f)
            )
        }
    }
}

@Composable
@Preview
private fun ConnectorHorizontalLinePreview() {
    OrganizationStructureAndroidTheme {
        ConnectorHorizontalLine(
            modifier = Modifier
                .width(80.dp)
                .height(40.dp)
        )
    }
}


@Composable
@Preview(locale = "ar")
private fun ConnectorHorizontalLineArPreview() {
    OrganizationStructureAndroidTheme {
        ConnectorHorizontalLine(
            modifier = Modifier
                .width(80.dp)
                .height(40.dp)
        )
    }
}