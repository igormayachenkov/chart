package ru.igormayachenkov.chart.ui.model

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import ru.igormayachenkov.chart.data.model.DataItem
import ru.igormayachenkov.chart.data.model.DataSet


fun DataItem.toOffset() : Offset =
    Offset(
        x = x.toFloat(),
        y = y.toFloat()
    )

fun DataSet.toChart() : Chart =
    Chart(
        color  = Color.Red,
        points = items.map { it.toOffset() }
    )
