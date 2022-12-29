package com.gm.rebecca.adaptive_views_compose.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.gm.rebecca.adaptive_views_compose.data.Place

@Composable
fun PlaceListDetailComposable(
    places: List<Place>,
    modifier: Modifier = Modifier,
    selectedIndex: MutableState<Int> = rememberSaveable { mutableStateOf(0) }
) {
    Row(
        modifier = modifier,
    ) {
        PlaceListComposable(
            places = places,
            modifier = modifier.weight(1f),
            onItemSelected = { index ->
                selectedIndex.value = index
            })

        if (places.isNotEmpty()) {
            val place = places[selectedIndex.value]
            PlaceDetailComposable(modifier = modifier.weight(1f), place = place)
        }
    }
}