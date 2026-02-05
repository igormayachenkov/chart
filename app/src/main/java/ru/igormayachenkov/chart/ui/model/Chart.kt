package ru.igormayachenkov.chart.ui.model

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

data class Chart(
    val color: Color,
    val points: List<Offset>
)
