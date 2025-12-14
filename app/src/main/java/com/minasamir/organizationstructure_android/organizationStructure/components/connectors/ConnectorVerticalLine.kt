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
import com.minasamir.organizationstructure_android.ui.theme.OrganizationStructureAndroidTheme

@Composable
fun ConnectorVerticalLine(
    modifier: Modifier,
    color: Color = Color(0xFFCCCCCC)
) {
    Canvas(
        modifier = modifier
    ) {
        drawLine(
            color = color,
            start = Offset(size.width / 2, 0f),
            end = Offset(size.width / 2, size.height),
            strokeWidth = 1.dp.toPx(),
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(15f, 10f), 0f)
        )
    }
}

@Composable
@Preview
private fun ConnectorVerticalLinePreview() {
    OrganizationStructureAndroidTheme {
        ConnectorVerticalLine(
            modifier = Modifier
                .width(40.dp)
                .height(80.dp)
        )
    }
}