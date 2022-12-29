package com.gm.rebecca.adaptive_views_compose.util

sealed class Screen(val route: String) {
    object Places : Screen("places")

    object PlaceDetail : Screen("places/{placeIndex}") {
        fun createRoute(index: Int) = "places/$index"
    }

    object DeletedPlaces : Screen("deletedPlaces")

    object Profile : Screen("profile")
}

/**
 * Different type of navigation depending on size and state.
 */
enum class NavigationType {
    BOTTOM_NAVIGATION, NAVIGATION_RAIL, PERMANENT_NAVIGATION_DRAWER
}

/**
 * Content shown depending on size and state of device.
 */
enum class ContentType {
    LIST_ONLY, LIST_AND_DETAIL
}