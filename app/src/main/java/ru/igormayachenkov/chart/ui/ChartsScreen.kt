package ru.igormayachenkov.chart.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.igormayachenkov.chart.data.DataListRepoMock
import ru.igormayachenkov.chart.ui.model.Chart
import ru.igormayachenkov.chart.ui.theme.ChartTheme
import kotlin.math.max
import kotlin.math.min

@Composable
fun ChartsScreen(state: ChartsUiState) {
    Surface(modifier = Modifier.fillMaxSize()) {
        val textMeasurer = rememberTextMeasurer()
        val textStyle = TextStyle(
            fontSize = 20.sp,
            color = Color.Yellow,
            background = Color.Transparent
        )

        if(!state.bounds.isEmpty) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                // Common origin (pivot)
                val originX = 100f
                val originY = size.height - 100f
                // Charts scale
                val scaleX =  (size.width - 100)  / state.bounds.width
                val scaleY = -(size.height - 200) / state.bounds.height

                // GRID
                withTransform({
                    translate(left = originX, top = originY)
                    scale(scaleX = 1f, scaleY = -1f, pivot = Offset(0f, 0f))
                }) {
                    // AXISes
                    drawLine(
                        color = Color.White,
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                    )
                    drawLine(
                        color = Color.White,
                        start = Offset(0f, 0f),
                        end = Offset(0f, size.height),
                    )

                }

                // CHARTS
                withTransform({
                    translate(
                        left = originX,
                        top = originY
                    )
//                scale(
//                    scaleX = scaleX,
//                    scaleY = scaleY,
//                    pivot  = Offset(0f, 0f)
//                )
                }) {
                    state.charts.forEach { chart ->
                        drawPoints(
                            points = chart.points.map { it.copy(it.x * scaleX, it.y * scaleY) },
                            pointMode = PointMode.Polygon,// PointMode.Points draws individual dots, Lines connects pairs, and Polygon connects all points in sequence.
                            color = chart.color,
                            strokeWidth = 2 * Stroke.DefaultMiter,
                            cap = StrokeCap.Round, // Makes points rounded
                        )
                    }
                }

                // LABELS
                withTransform({
                    translate(left = originX, top = originY)
//                scale(scaleX = 1f, scaleY = 1f, pivot = Offset(0f, 0f))
                }) {
                    drawText(
                        textMeasurer = textMeasurer,
                        text = "screen size: $size",
                        //text = "range: $range",
                        topLeft = Offset(x = 0f, y = -1f),
                        style = textStyle
                    )
                }
            }
        }
    }
}

//--------------------------------------------------------------------------------------------------
// PREVIEW
//@Preview(showBackground = true)
//@Composable
//private fun Preview1(){
//    val state = ChartsUiState(
//        charts = listOf(
//            Chart(
//                color = Color.Green,
//                points = listOf(
//                    Offset(0f, 0f),
//                    Offset(100f, 100f),
//                    Offset(200f, 200f),
//                    Offset(300f, 220f),
//                    Offset(400f, 250f),
//                    Offset(500f, 300f),
//                )
//            ),
//            Chart(
//                color = Color.Red,
//                points = listOf(
//                    Offset(0f,500f),
//                    Offset(100f,400f),
//                    Offset(200f,350f),
//                    Offset(300f,150f),
//                    Offset(400f,100f),
//                    Offset(500f,-100f),
//                )
//            ),
//        )
//    )
//    ChartTheme(darkTheme = true) {
//        Surface() {
//            ChartsScreen(state)
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
private fun Preview2(){
    val model = remember { ChartsViewModel(DataListRepoMock()) }
    val state by model.stateFlow.collectAsState()
    ChartTheme(darkTheme = true) {
        Surface() {
            ChartsScreen(state)
        }
    }
}