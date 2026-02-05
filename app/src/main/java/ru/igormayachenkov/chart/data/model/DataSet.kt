package ru.igormayachenkov.chart.data.model

data class DataSet(
    val id : Long,
    val name: String,
    val items : List<DataItem>
)
