package ru.igormayachenkov.chart.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import ru.igormayachenkov.chart.data.DataListRepo
import ru.igormayachenkov.chart.ui.model.Chart
import ru.igormayachenkov.chart.ui.model.toChart
import ru.igormayachenkov.chart.ui.model.toOffset
import javax.inject.Inject

data class ChartsUiState(
    val charts : List<Chart>
)

@HiltViewModel
class ChartsViewModel @Inject constructor(
    val repo: DataListRepo
) :  ViewModel() {
    val stateFlow = repo.allDataSets.map { dataSets ->
        ChartsUiState(
            charts = dataSets.map { it.toChart() }
        )
    }.stateIn(
        scope = viewModelScope, // TODO add withContext
        started = SharingStarted.Eagerly,
        initialValue = ChartsUiState(emptyList())
    )
}