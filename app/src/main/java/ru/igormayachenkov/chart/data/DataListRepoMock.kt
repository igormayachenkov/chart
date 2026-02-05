package ru.igormayachenkov.chart.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.igormayachenkov.chart.data.model.DataItem
import ru.igormayachenkov.chart.data.model.DataSet
import javax.inject.Inject

class DataListRepoMock @Inject constructor() : DataListRepo{
    override val allDataSets: Flow<List<DataSet>> = flow{
        emit(MockData.dataSetList)
    }
}