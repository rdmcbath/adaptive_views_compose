package com.gm.rebecca.adaptive_views_compose.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gm.rebecca.adaptive_views_compose.MainViewModel
import com.gm.rebecca.adaptive_views_compose.util.ContentType
import com.gm.rebecca.adaptive_views_compose.util.Screen

@Composable
fun NavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: MainViewModel = viewModel(),
    contentType: ContentType
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Places.route,
        modifier = modifier
    ) {
        composable(route = Screen.Places.route) {
           PlacesScreen(
                viewModel = viewModel,
                contentType = contentType,
                getPlaces = { viewModel.getPlaces() },
                goToDetailScreen = { index ->
                    val route = Screen.PlaceDetail.createRoute(index)
                    navController.navigate(route)
                }
            )
        }
        composable(route = Screen.PlaceDetail.route) { backStackEntry ->
            val placeIndex =
                backStackEntry.arguments?.getString("placeIndex")?.toInt() ?: 0
            PlaceDetailScreen(
                viewModel =viewModel,
                placeIndex = placeIndex
            )
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen()
        }
        composable(route = Screen.DeletedPlaces.route) {
            DeletedPlacesScreen(viewModel = viewModel)
        }
    }
}