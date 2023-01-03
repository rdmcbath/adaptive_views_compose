package com.gm.rebecca.adaptive_views_compose.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.gm.rebecca.adaptive_views_compose.MainViewModel
import com.gm.rebecca.adaptive_views_compose.navigation.AppBottomNavigationBar
import com.gm.rebecca.adaptive_views_compose.navigation.AppNavigationRail
import com.gm.rebecca.adaptive_views_compose.navigation.NavHost
import com.gm.rebecca.adaptive_views_compose.util.ContentType
import com.gm.rebecca.adaptive_views_compose.util.NavigationType

@Composable
fun AppContent(
    navigationType: NavigationType,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: MainViewModel = viewModel(),
    onDrawerClicked: () -> Unit = {},
    contentType: ContentType
) {
    Row(modifier = Modifier.fillMaxSize()) {
        /*   Wrap both navigation rail and bottom navigation in the AnimatedVisibility() composable.
             This animates the entry and exit visibility of each navigation depending on navigationType
             The navigationWrapper uses navigationType to determine placement of navigation rail or
              bottom navigation to implement dynamic navigation on different devices.*/
        AnimatedVisibility(visible = navigationType == NavigationType.NAVIGATION_RAIL) {
            AppNavigationRail(
                onDrawerClicked = onDrawerClicked,
                navController = navController
            )
        }
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            NavHost(
                modifier = modifier.weight(1f),
                contentType = contentType,
                navController = navController,
                viewModel = viewModel
            )
            AnimatedVisibility(visible = navigationType == NavigationType.BOTTOM_NAVIGATION) {
                AppBottomNavigationBar(
                    navController = navController
                )
            }
        }
    }
}