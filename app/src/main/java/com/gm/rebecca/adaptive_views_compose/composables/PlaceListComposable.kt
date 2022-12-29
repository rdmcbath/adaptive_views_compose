package com.gm.rebecca.adaptive_views_compose.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gm.rebecca.adaptive_views_compose.data.Place

@Composable
fun PlaceListComposable(
    onItemSelected: (Int) -> Unit,
    places: List<Place>,
    modifier: Modifier = Modifier,
    ) {
    LazyColumn(modifier = modifier.padding(16.dp)) {
        itemsIndexed(places) { index, place ->
            PlaceItemComposable(
                modifier = modifier.clickable {
                    onItemSelected(index)
                },
                place = place,
            )
        }
    }
}
