package ru.igormayachenkov.chart.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.igormayachenkov.chart.data.MockData
import ru.igormayachenkov.chart.data.model.DataSet
import ru.igormayachenkov.chart.ui.theme.ChartTheme
import ru.igormayachenkov.geo.feature.split.SplitScreen
import ru.igormayachenkov.geo.feature.split.SplitState
import ru.igormayachenkov.geo.feature.split.SplitUiState

@Composable
fun DataListScreen(
    dataList:List<DataSet>
){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues( 5.dp)
    ) {
        items(items=dataList, key={it.id}){
            Text(it.name)
        }

    }

}
//--------------------------------------------------------------------------------------------------
// PREVIEW
@Preview(showBackground = true)
@Composable
private fun Preview() {
    ChartTheme(darkTheme = true) {
        Surface {
            DataListScreen(MockData.dataSetList)
        }
    }
}