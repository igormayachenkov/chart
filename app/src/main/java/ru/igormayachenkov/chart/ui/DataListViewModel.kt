package ru.igormayachenkov.chart.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import ru.igormayachenkov.chart.data.DataListRepo
import javax.inject.Inject

@HiltViewModel
class DataListViewModel @Inject constructor(
    val repo: DataListRepo
) : ViewModel(){
    private val scope = CoroutineScope(Dispatchers.IO)
    val dataListFlow = repo.allDataSets.stateIn(
        scope = scope,
        started = SharingStarted.Eagerly,
        initialValue = emptyList()
    )

}