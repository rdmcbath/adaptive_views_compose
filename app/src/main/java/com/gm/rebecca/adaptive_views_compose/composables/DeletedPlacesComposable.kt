package com.gm.rebecca.adaptive_views_compose.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gm.rebecca.adaptive_views_compose.data.Place

@Preview
@Composable
fun DeletedPlacesComposable(
    modifier: Modifier = Modifier,
    deletedPlaces: List<Place> = emptyList()
) {
    LazyColumn{
        itemsIndexed(deletedPlaces){index, place ->
            PlaceItemComposable(place = place)
        }
    }
}