package com.gm.rebecca.adaptive_views_compose.composables

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Icon
import androidx.compose.material.NavigationRail
import androidx.compose.material.NavigationRailItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gm.rebecca.adaptive_views_compose.R
import com.gm.rebecca.adaptive_views_compose.util.Screen

@Composable
@Preview
fun AppNavigationRail(
    onDrawerClicked: () -> Unit = {},
    selectedDestination: String = Screen.Places.route,
    navController: NavController = rememberNavController()
) {
    NavigationRail(modifier = Modifier.fillMaxHeight()) {
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
        NavigationRailItem(
            selected = selectedDestination == Screen.Places.route,
            onClick = {
                navController.navigate(Screen.Places.route) {
                    popUpTo(Screen.Places.route) { inclusive = true }
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = stringResource(id = R.string.places)
                )
            }
        )
        NavigationRailItem(
            selected = selectedDestination == Screen.Profile.route,
            onClick = {
                navController.navigate(Screen.Profile.route) {
                    popUpTo(Screen.Places.route)
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    stringResource(id = R.string.profile)
                )
            }
        )

        NavigationRailItem(
            selected = selectedDestination == Screen.DeletedPlaces.route,
            onClick = { navController.navigate(Screen.DeletedPlaces.route){
                popUpTo(Screen.Places.route)
            } },
            icon = {
                Icon(
                    imageVector = Icons.Default.Delete,
                    stringResource(id = R.string.deleted)
                )
            }
        )
    }
}