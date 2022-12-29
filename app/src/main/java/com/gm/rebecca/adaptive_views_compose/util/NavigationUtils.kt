package com.gm.rebecca.adaptive_views_compose.util

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.gm.rebecca.adaptive_views_compose.R

//sealed class Screen(val route: String) {
//    object Places : Screen("places")
//
//    object PlaceDetail : Screen("places/{placeIndex}") {
//        fun createRoute(index: Int) = "places/$index"
//    }
//
//    object DeletedPlaces : Screen("deletedPlaces")
//
//    object Profile : Screen("profile")
//}

sealed class Screen(
    val route: String,
    @StringRes val label: Int?,
    val icon_outlined: ImageVector?,
    val icon_filled: ImageVector?
) {
    object Places : Screen(
        route = "places",
        label = R.string.homeMap,
        icon_outlined = Icons.Outlined.Home,
        icon_filled = Icons.Filled.Home
    )
    object Profile : Screen(
        route = "profile",
        label = R.string.profile,
        icon_outlined = Icons.Outlined.AccountCircle,
        icon_filled = Icons.Filled.AccountCircle,
    )
    object DeletedPlaces : Screen(
        route = "deletedPlaces",
        label = R.string.deleted,
        icon_outlined = Icons.Outlined.Delete,
        icon_filled = Icons.Filled.Delete,
    )
    object PlaceDetail : Screen(
        "places/{placeIndex}",
        label = null,
        icon_outlined = null,
        icon_filled = null
    ) {
        fun createRoute(index: Int) = "places/$index"
    }
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

enum class Page(val title:String, val content: String?){
    HOME("Places","places"),
    PROFILE("Profile","profile"),
    DELETES("Deletes","deletedPlaces")
}