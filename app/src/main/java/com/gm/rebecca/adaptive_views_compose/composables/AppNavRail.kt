package com.gm.rebecca.adaptive_views_compose.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.NavigationRail
import androidx.compose.material.NavigationRailItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gm.rebecca.adaptive_views_compose.R
import com.gm.rebecca.adaptive_views_compose.util.Page
import com.gm.rebecca.adaptive_views_compose.util.Screen

@Composable
@Preview
fun AppNavigationRail(
    onDrawerClicked: () -> Unit = {},
    selectedDestination: String = Screen.Places.route,
    navController: NavController = rememberNavController()
) {
    val pages = Page.values()
    val icons = listOf(Icons.Filled.Home, Icons.Filled.Person, Icons.Filled.Delete)

    Row {
        NavigationRail {
            NavigationRailItem(
                selected = false,
                onClick = onDrawerClicked,
                icon = {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = stringResource(id = R.string.app_name)
                    )
                }
            )
            pages.forEachIndexed { index, page ->
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                val selected = pages[index].content == currentDestination?.route
                when (page) {
                    Page.HOME -> {
                        NavigationRailItem(
                            label = {
                                Text(
                                    page.title,
                                    color = colorResource(id = R.color.colorPrimary)
                                )
                            },
                            icon = {
                                Icon(
                                    icons[index],
                                    contentDescription = stringResource(id = R.string.places),
                                    tint = if (selected) colorResource(id = R.color.colorPrimary) else colorResource(
                                        id = R.color.lavender
                                    )
                                )
                            },
                            selected = currentDestination?.hierarchy?.any { it.route == Screen.Places.route } == true,
                            onClick = {
                                navController.navigate(Screen.Places.route) {
                                    popUpTo(Screen.Places.route) { inclusive = true }
                                }
                            },
                            alwaysShowLabel = false
                        )
                    }
                    Page.PROFILE -> {
                        NavigationRailItem(
                            label = {
                                Text(
                                    page.title,
                                    color = colorResource(id = R.color.colorPrimary)
                                )
                            },
                            icon = {
                                Icon(
                                    icons[index],
                                    contentDescription = stringResource(id = R.string.profile),
                                    tint = if (selected) colorResource(id = R.color.colorPrimary) else colorResource(
                                        id = R.color.lavender
                                    )
                                )
                            },
                            selected =currentDestination?.hierarchy?.any { it.route == Screen.Profile.route } == true,
                            onClick = {
                                navController.navigate(Screen.Profile.route) {
                                    popUpTo(Screen.Places.route) { inclusive = true }
                                }
                            },
                            alwaysShowLabel = false
                        )
                    }
                    Page.DELETES -> {
                        NavigationRailItem(
                            label = { Text(
                                page.title,
                                color = colorResource(id = R.color.colorPrimary)
                            )
                                    },
                            icon = {
                                Icon(
                                    icons[index],
                                    contentDescription = stringResource(id = R.string.deleted),
                                    tint = if (selected) colorResource(id = R.color.colorPrimary) else colorResource(
                                        id = R.color.lavender
                                    )
                                )
                            },
                            selected = currentDestination?.hierarchy?.any { it.route == Screen.DeletedPlaces.route } == true,
                            onClick = {
                                navController.navigate(Screen.DeletedPlaces.route) {
                                    popUpTo(Screen.Places.route) { inclusive = true }
                                }
                            },
                            alwaysShowLabel = false
                        )
                    }
                }
            }
        }
    }
}


//    NavigationRail(modifier = Modifier.fillMaxHeight()) {
//        NavigationRailItem(
//            selected = false,
//            onClick = onDrawerClicked,
//            icon = {
//                Icon(
//                    imageVector = Icons.Default.Menu,
//                    contentDescription = stringResource(id = R.string.app_name)
//                )
//            }
//        )
//        NavigationRailItem(
//            selected = selectedDestination == Screen.Places.route,
//            onClick = {
//                navController.navigate(Screen.Places.route) {
//                    popUpTo(Screen.Places.route) { inclusive = true }
//                }
//            },
//            icon = {
//                Icon(
//                    imageVector = Icons.Default.Home,
//                    contentDescription = stringResource(id = R.string.places)
//                )
//            }
//        )
//        NavigationRailItem(
//            modifier = Modifier.background(if (isSelected) colorResource(id = R.color.purple_200)
//            else colorResource(id = R.color.lavender)),
//            selected = selectedDestination == Screen.Profile.route,
//            onClick = {
//                navController.navigate(Screen.Profile.route) {
//                    popUpTo(Screen.Places.route)
//                    isSelected = true
//                }
//            },
//            icon = {
//                Icon(
//                    imageVector = Icons.Default.Person,
//                    stringResource(id = R.string.profile)
//                )
//            }
//        )
//
//        NavigationRailItem(
//            selected = selectedDestination == Screen.DeletedPlaces.route,
//            onClick = {
//                navController.navigate(Screen.DeletedPlaces.route) {
//                popUpTo(Screen.Places.route)
//            }
//                isSelected = true},
//            icon = {
//                Icon(
//                    imageVector = Icons.Default.Delete,
//                    stringResource(id = R.string.deleted)
//                )
//            }
//        )
//    }
//}