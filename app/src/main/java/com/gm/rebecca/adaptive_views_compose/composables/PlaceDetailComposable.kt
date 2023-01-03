package com.gm.rebecca.adaptive_views_compose.composables

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gm.rebecca.adaptive_views_compose.R
import com.gm.rebecca.adaptive_views_compose.data.Place
import com.gm.rebecca.adaptive_views_compose.util.LocationUtils
import com.google.android.gms.maps.model.*
import com.google.maps.android.compose.*

@Composable
fun PlaceDetailComposable(
    modifier: Modifier = Modifier,
    place: Place = Place(
        name = "",
        location = "",
        description = "",
        latLng = LatLng(40.761509, -73.978271),
    )
) {
    val position = LocationUtils.getPlaceLocation(place)
    val cameraPositionState = rememberCameraPositionState()
    cameraPositionState.position = CameraPosition.fromLatLngZoom(
        position, 11f
    )
    val mapStyleOptions = MapStyleOptions.loadRawResourceStyle(
        LocalContext.current, R.raw.style_json
    )
    val mapProperties by remember {
        mutableStateOf(mapStyleOptions)
    }
    // Drawing on the map is accomplished with a child-based API
    val markerClick: (Marker) -> Boolean = {
        Log.d("becca", "${it.title} was clicked")
        cameraPositionState.projection?.let { projection ->
            Log.d("becca", "The current projection is: $projection")
        }
        false
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = place.name,
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.padding(vertical = 2.dp))

        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        bottomEnd = 10.dp,
                        bottomStart = 10.dp,
                        topEnd = 10.dp,
                        topStart = 10.dp
                    )
                ),
        ) {
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState,
                properties = MapProperties(mapStyleOptions = mapProperties),
                uiSettings = MapUiSettings(zoomControlsEnabled = true)
            ) {
                Marker(
                    state = MarkerState(position = position)
                )
                MarkerInfoWindow(
                    state = MarkerState(position),
                    icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE),
                    title = place.name,
                    snippet = place.description,
                    onClick = markerClick,
                    content = {
                        CustomInfoWindow(title = it.title, description = it.snippet)
                    }
                )
            }
        }
    }
}
