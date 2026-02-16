package ru.igormayachenkov.chart.ui.model

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color

/**
 * - DataSet projection into 2D Cartesian space
 * - some props for drawing
 */
data class Chart(
    val color: Color,
    val points: List<Offset>,
    val bounds: Rect
)
