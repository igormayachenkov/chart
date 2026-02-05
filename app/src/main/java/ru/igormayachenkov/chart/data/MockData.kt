package ru.igormayachenkov.chart.data

import ru.igormayachenkov.chart.data.model.DataItem
import ru.igormayachenkov.chart.data.model.DataSet

object MockData {
    val dataSetList = listOf(
        DataSet(1,"function: y = x", listOf(
            DataItem(0,0.0),
            DataItem(1,1.0),
            DataItem(2,2.0),
            DataItem(3,3.0),
            DataItem(4,4.0),
            DataItem(5,5.0),
        )),
        DataSet(2,"function: y = x^2", listOf(
            DataItem(0, 0.0),
            DataItem(1, 1.0),
            DataItem(2, 4.0),
            DataItem(3, 9.0),
            DataItem(4,16.0),
            DataItem(5,25.0),
        )),
        DataSet(3,"function: y = sqrt(x)", listOf(
            DataItem(0, 0.0),
            DataItem(1, 1.0),
            DataItem(2, 1.41),
            DataItem(3, 1.73),
            DataItem(4, 2.0),
            DataItem(5, 2.236),
        )),
    )
}