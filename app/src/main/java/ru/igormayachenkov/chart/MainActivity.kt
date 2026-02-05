package ru.igormayachenkov.chart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import ru.igormayachenkov.chart.ui.theme.ChartTheme
import ru.igormayachenkov.geo.feature.split.SplitScreen
import ru.igormayachenkov.geo.feature.split.SplitState
import ru.igormayachenkov.geo.feature.split.SplitStateSaver
import ru.igormayachenkov.geo.feature.split.SplitStateSaverImpl
import ru.igormayachenkov.geo.feature.split.SplitUiState
import ru.igormayachenkov.geo.feature.split.SplitViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChartTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        val context = LocalContext.current
                        val splitViewModel = remember{SplitViewModel(SplitStateSaverImpl(context))}
                        val splitUiState by splitViewModel.stateFlow.collectAsState()
                        SplitScreen(
                            firstPanel = {
                                Greeting(                            name = "first"                            )
                            },
                            secondPanel = {
                                Text("Second")
                            },
                            uiState = splitUiState,
                            setWeight = splitViewModel::setWeight,
                            saveData = splitViewModel::saveData

                        )

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChartTheme {
        Surface {
            SplitScreen(
                firstPanel = {},
                secondPanel = {},
                uiState = SplitUiState(SplitState.SPLIT,0.5f),
                {},{}
            )
        }
    }
}