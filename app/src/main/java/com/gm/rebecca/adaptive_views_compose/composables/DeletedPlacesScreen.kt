package com.gm.rebecca.adaptive_views_compose.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gm.rebecca.adaptive_views_compose.MainViewModel

@Preview
@Composable
fun DeletedPlacesScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel()
) {
    val getDeletedPlaces by rememberUpdatedState{viewModel.getDeletedPlaces()}
    LaunchedEffect(true){
        getDeletedPlaces()
    }
    val places = viewModel.deletedPlaces.collectAsState().value
    if (places.isNotEmpty()) {
        DeletedPlacesComposable(deletedPlaces = places)
    } else {
        Text(
            text = "No Deleted Places yet \uD83D\uDC48",
            modifier = Modifier.fillMaxSize().padding(32.dp),
            fontSize = 21.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center
        )
    }
}