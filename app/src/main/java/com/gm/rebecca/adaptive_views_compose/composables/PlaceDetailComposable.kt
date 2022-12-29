package com.gm.rebecca.adaptive_views_compose.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gm.rebecca.adaptive_views_compose.R
import com.gm.rebecca.adaptive_views_compose.data.Place
import com.gm.rebecca.adaptive_views_compose.util.LocationUtils
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.*

@Composable
fun PlaceDetailComposable(
    modifier: Modifier,
    place: Place = Place(
        name = "National Gallery of Art",
        location = "Washington, D.C.",
        description = "Identified as one of the largest and most influential museums of modern art in the world",
        latLng = LatLng(40.761509, -73.978271),
    )
) {
    val cameraPositionState = rememberCameraPositionState()
    cameraPositionState.position = CameraPosition.fromLatLngZoom(
        LocationUtils.getPlaceLocation(place), 11f
    )

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

        Text(
            text = AnnotatedString(text = place.description),
            style = TextStyle(
                fontFamily = FontFamily.Serif,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            ),
        )
        Spacer(modifier = Modifier.padding(vertical = 2.dp))

        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        bottomEnd = 10.dp,
                        bottomStart = 10.dp
                    )
                ),
        ) {
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState,
                properties = MapProperties(
                    mapStyleOptions = MapStyleOptions.loadRawResourceStyle(
                        LocalContext.current, R.raw.style_json)
                ),
                uiSettings = MapUiSettings(zoomControlsEnabled = true)
            ) {
                Marker(
                    state = MarkerState(position = LocationUtils.getPlaceLocation(place)),
                    title = place.name
                )
            }
        }
    }
}
