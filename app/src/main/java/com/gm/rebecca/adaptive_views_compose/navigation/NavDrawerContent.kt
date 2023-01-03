package com.gm.rebecca.adaptive_views_compose.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gm.rebecca.adaptive_views_compose.R
import com.gm.rebecca.adaptive_views_compose.util.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawerContent(
    navController: NavController,
    modifier: Modifier = Modifier,
    selectedDestination: String = Screen.Places.route,
    onDrawerClicked: () -> Unit = {}
) {
    Column(
        modifier
            .wrapContentWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .padding(24.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.app_name).uppercase(),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            IconButton(onClick = onDrawerClicked) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = stringResource(id = R.string.app_name)
                )
            }
        }

        NavigationDrawerItem(
            selected = selectedDestination == Screen.Places.route,
            label = {
                Text(
                    text = stringResource(id = R.string.homeMap),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = stringResource(id = R.string.homeMap)
                )
            },
            colors = NavigationDrawerItemDefaults.colors(unselectedContainerColor = Color.Transparent),
            onClick = {
                navController.navigate(Screen.Places.route) {
                    navController.navigate(Screen.Places.route) {
                        popUpTo(Screen.Places.route) { inclusive = true }
                    }
                }
            }
        )
        NavigationDrawerItem(
            selected = selectedDestination == Screen.Profile.route,
            label = {
                Text(
                    text = stringResource(id = R.string.profile),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = stringResource(id = R.string.profile)
                )
            },
            colors = NavigationDrawerItemDefaults.colors(unselectedContainerColor = Color.Transparent),
            onClick = {
                navController.navigate(Screen.Profile.route) {
                    popUpTo(Screen.Places.route)
                }
            }
        )
        NavigationDrawerItem(
            selected = selectedDestination == Screen.DeletedPlaces.route,
            label = {
                Text(
                    text = stringResource(id = R.string.deleted),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = stringResource(id = R.string.deleted)
                )
            },
            colors = NavigationDrawerItemDefaults.colors(unselectedContainerColor = Color.Transparent),
            onClick = {
                navController.navigate(Screen.DeletedPlaces.route) {
                    popUpTo(Screen.Places.route)
                }
            }
        )
    }
}