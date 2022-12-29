package com.gm.rebecca.adaptive_views_compose.data

import kotlinx.coroutines.flow.flow

class PlaceRepositoryImpl: PlaceRepository {
    override fun getPlaces() = flow {
        val places = PlacesProvider.places
        emit(places)
    }

    override fun getDeletedPlaces() = flow{
        val deletedPlaces = PlacesProvider.deletedPlaces
        emit(deletedPlaces)
    }
}