package com.gm.rebecca.adaptive_views_compose.composables

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gm.rebecca.adaptive_views_compose.MainViewModel
import com.gm.rebecca.adaptive_views_compose.data.Place
import com.gm.rebecca.adaptive_views_compose.util.ContentType

@Composable
fun PlacesScreen(
    getPlaces: () -> Unit,
    goToDetailScreen: (placeIndex: Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel(),
    contentType: ContentType = ContentType.LIST_ONLY
) {
    val onGetPlaces by rememberUpdatedState(newValue = getPlaces)
    LaunchedEffect(true) {
        onGetPlaces()
    }
    val places = viewModel.places.collectAsState().value
    if (contentType == ContentType.LIST_AND_DETAIL) {
        PlaceListDetailComposable(places = places)
    } else {
        PlaceListComposable(
            places = places,
            onItemSelected = goToDetailScreen
        )
    }
}