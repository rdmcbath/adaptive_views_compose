package com.gm.rebecca.adaptive_views_compose.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gm.rebecca.adaptive_views_compose.data.Place
import com.gm.rebecca.adaptive_views_compose.ui.theme.UiTheme
import com.google.android.gms.maps.model.LatLng

@Composable
fun PlaceItemComposable(
    modifier: Modifier = Modifier,
    place: Place = Place(
        name = "",
        location = "",
        description = "",
        latLng = LatLng(40.761509, -73.978271)
    ),
) {
    Card(
        modifier = modifier.padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface,
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(all = 16.dp)
        ) {
            Text(
                text = place.name,
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.padding(vertical = 2.dp))

            Text(
                text = place.location,
                fontFamily = FontFamily.Serif,
                fontSize = 19.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.padding(vertical = 2.dp))

            Text(
                text = "${place.description.subSequence(0, 25)}...",
                fontFamily = FontFamily.Serif,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview
@Composable
fun PlaceItemPreview() {
    UiTheme {
        PlaceItemComposable()
    }
}