package ru.igormayachenkov.chart.data

import kotlinx.coroutines.flow.Flow
import ru.igormayachenkov.chart.data.model.DataSet

interface DataListRepo {
    // Data
    val allDataSets : Flow<List<DataSet>>

    // Actions

}