package com.gm.rebecca.adaptive_views_compose.data

import com.google.android.gms.maps.model.LatLng

data class Place(
    val name: String,
    val location: String,
    val description: String,
    val latLng: LatLng
)