package ru.igormayachenkov.chart.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import ru.igormayachenkov.geo.feature.split.SplitScreen
import ru.igormayachenkov.geo.feature.split.SplitViewModel

@Composable
fun AppContent(modifier: Modifier){
    Box(modifier = modifier) {

        //val context = LocalContext.current
        //val splitViewModel = remember{SplitViewModel(SplitStateSaverImpl(context))}
        val splitViewModel = hiltViewModel<SplitViewModel>()
        val splitUiState by splitViewModel.stateFlow.collectAsState()
        SplitScreen(
            firstPanel = {
                Text(  "Chart")
            },
            secondPanel = {
                Text("Data")
            },
            uiState = splitUiState,
            setWeight = splitViewModel::setWeight,
            saveData = splitViewModel::saveData

        )
    }
}