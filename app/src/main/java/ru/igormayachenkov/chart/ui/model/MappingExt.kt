package ru.igormayachenkov.chart.ui.model

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import ru.igormayachenkov.chart.data.model.DataItem
import ru.igormayachenkov.chart.data.model.DataSet


fun DataItem.toOffset() : Offset =
    Offset(
        x = x.toFloat(),
        y = y.toFloat()
    )

fun DataSet.toChart() : Chart {
    val points = items.map { it.toOffset() }
    return Chart(
        color  = Color.Red,
        points = points,
        bounds = getOffsetListBounds(points)
    )
}

val invalidRect : Rect
    get() = Rect(
        Float.POSITIVE_INFINITY,
        Float.POSITIVE_INFINITY,
        Float.NEGATIVE_INFINITY,
        Float.NEGATIVE_INFINITY
    )

fun getOffsetListBounds(offsets: List<Offset>) : Rect =
    offsets.fold(invalidRect ) { acc, offset ->
        Rect(
            minOf(acc.left, offset.x),
            minOf(acc.top, offset.y),
            maxOf(acc.right, offset.x),
            maxOf(acc.bottom, offset.y)
        )
    }

fun getChartListBounds(charts: List<Chart>) : Rect =
    charts.fold(invalidRect){acc, chart->
        Rect(
            minOf(acc.left, chart.bounds.left),
            minOf(acc.top, chart.bounds.top),
            maxOf(acc.right, chart.bounds.right),
            maxOf(acc.bottom, chart.bounds.bottom)
        )
    }


