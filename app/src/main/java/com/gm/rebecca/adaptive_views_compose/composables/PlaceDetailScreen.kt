package com.gm.rebecca.adaptive_views_compose.composables

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gm.rebecca.adaptive_views_compose.MainViewModel
import com.gm.rebecca.adaptive_views_compose.data.Place

@Composable
fun PlaceDetailScreen(
    viewModel: MainViewModel = viewModel(),
    placeIndex: Int = 0,
) {
    val place: Place = viewModel.places.collectAsState().value[placeIndex]
    PlaceDetailComposable(
        modifier = Modifier,
        place = place
    )
}