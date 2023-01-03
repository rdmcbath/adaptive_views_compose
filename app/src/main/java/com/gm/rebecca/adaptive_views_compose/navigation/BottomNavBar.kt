package com.gm.rebecca.adaptive_views_compose.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.gm.rebecca.adaptive_views_compose.R
import com.gm.rebecca.adaptive_views_compose.util.Screen

@Composable
fun AppBottomNavigationBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colors.background
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        NavigationBarItem(
            selected = currentDestination?.hierarchy?.any { it.route == Screen.Places.route } == true,
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

        NavigationBarItem(
            selected = currentDestination?.hierarchy?.any { it.route == Screen.Profile.route } == true,
            onClick = {
                navController.navigate(Screen.Profile.route) {
                    popUpTo(Screen.Places.route)
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = stringResource(id = R.string.profile)
                )
            }
        )
        NavigationBarItem(
            selected = currentDestination?.hierarchy?.any { it.route == Screen.DeletedPlaces.route } == true,
            onClick = {
                navController.navigate(Screen.DeletedPlaces.route) {
                    popUpTo(Screen.Places.route)
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Delete,
                    contentDescription = stringResource(id = R.string.deleted)
                )
            }
        )
    }
}