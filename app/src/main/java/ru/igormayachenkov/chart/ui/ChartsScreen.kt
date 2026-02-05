package ru.igormayachenkov.chart.ui

import android.R
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.tooling.preview.Preview
import ru.igormayachenkov.chart.ui.model.Chart
import ru.igormayachenkov.chart.ui.theme.ChartTheme

@Composable
fun ChartsScreen(state: ChartsUiState) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        withTransform({
            translate(left=50f, top = 1100f)
            scale(scaleX = 0.9f, scaleY = -0.9f, pivot = Offset(0f,0f))
        }){
            // AXISes
            drawLine(
                color = Color.White,
                start = Offset(0f,0f),
                end   = Offset(1000f,0f),
            )
            drawLine(
                color = Color.White,
                start = Offset(0f,0f),
                end   = Offset(0f,1000f),
            )
            // CHARTS
            state.charts.forEach { chart ->
                drawPoints(
                    points = chart.points,
                    pointMode = PointMode.Polygon,// PointMode.Points draws individual dots, Lines connects pairs, and Polygon connects all points in sequence.
                    color = chart.color,
                    strokeWidth = 20f,//Stroke.DefaultMiter,
                    cap = StrokeCap.Round, // Makes points rounded
                )
            }
        }
    }
}

//--------------------------------------------------------------------------------------------------
// PREVIEW
@Preview(showBackground = true)
@Composable
private fun Preview(){
    val state = ChartsUiState(
        charts = listOf(
            Chart(
                color = Color.Green,
                points = listOf(
                    Offset(0f, 0f),
                    Offset(100f, 100f),
                    Offset(200f, 200f),
                    Offset(300f, 220f),
                    Offset(400f, 250f),
                    Offset(500f, 300f),
                )
            ),
            Chart(
                color = Color.Red,
                points = listOf(
                    Offset(0f,500f),
                    Offset(100f,400f),
                    Offset(200f,350f),
                    Offset(300f,150f),
                    Offset(400f,100f),
                    Offset(500f,-100f),
                )
            ),
        )
    )
    ChartTheme(darkTheme = true) {
        Surface() {
            ChartsScreen(state)
        }
    }
}