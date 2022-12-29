package com.gm.rebecca.adaptive_views_compose.data

import kotlinx.coroutines.flow.Flow

interface PlaceRepository {
    fun getPlaces(): Flow<List<Place>>
    fun getDeletedPlaces(): Flow<List<Place>>
}