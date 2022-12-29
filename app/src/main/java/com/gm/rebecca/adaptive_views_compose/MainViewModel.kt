package com.gm.rebecca.adaptive_views_compose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gm.rebecca.adaptive_views_compose.data.Place
import com.gm.rebecca.adaptive_views_compose.data.PlaceRepository
import com.gm.rebecca.adaptive_views_compose.data.PlaceRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: PlaceRepository = PlaceRepositoryImpl()
) : ViewModel() {

    private val _places = MutableStateFlow<List<Place>>(emptyList())
    val places: StateFlow<List<Place>>
        get() = _places

    private val _deletedPlaces = MutableStateFlow<List<Place>>(emptyList())
    val deletedPlaces: StateFlow<List<Place>>
        get() = _deletedPlaces

    fun getPlaces() {
        viewModelScope.launch {
            val result = repository.getPlaces()
            result.collect { placeList ->
                _places.value = placeList
            }
        }
    }

    fun getDeletedPlaces() {
        viewModelScope.launch {
            val result = repository.getDeletedPlaces()
            result.collect { placeList ->
                _deletedPlaces.value = placeList
            }
        }
    }
}