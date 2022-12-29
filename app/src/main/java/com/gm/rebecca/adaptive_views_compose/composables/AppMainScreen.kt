package com.gm.rebecca.adaptive_views_compose.composables

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.gm.rebecca.adaptive_views_compose.MainViewModel
import com.gm.rebecca.adaptive_views_compose.ui.theme.UiTheme
import com.gm.rebecca.adaptive_views_compose.util.ContentType
import com.gm.rebecca.adaptive_views_compose.util.DevicePosture
import com.gm.rebecca.adaptive_views_compose.util.NavigationType

@Composable
fun AppMainScreen(
    windowSize: WindowWidthSizeClass,
    foldingPosture: DevicePosture,
    viewModel: MainViewModel = viewModel()
) {
    val navController = rememberNavController()
    val navigationType: NavigationType
    val contentType: ContentType
    /*Using a when statement, initialize navigationType with the correct value depending on the window size class
    * For a foldable device in book posture, set the value to LIST_DETAIL. This will separate list view and detail view
    * at the hinge area. It helps avoid placing content or touch targets at the hinge area.*/
    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = NavigationType.BOTTOM_NAVIGATION
            contentType = ContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Medium -> {
            navigationType = NavigationType.NAVIGATION_RAIL
            contentType = if (foldingPosture is DevicePosture.BookPosture
                || foldingPosture is DevicePosture.Separating
            ) {
                ContentType.LIST_AND_DETAIL
            } else {
                ContentType.LIST_ONLY
            }
        }
        WindowWidthSizeClass.Expanded -> {
            /*Handles fold state to avoid placing content or touching action at the
               hinge area. When a device is in BookPosture, use a navigation rail and divide content
               around the hinge. For large desktops or tablets, use a permanent navigation drawer*/
            navigationType = if (foldingPosture is DevicePosture.BookPosture) {
                NavigationType.NAVIGATION_RAIL
            } else {
                NavigationType.PERMANENT_NAVIGATION_DRAWER
            }
            contentType = ContentType.LIST_AND_DETAIL
        }
        else -> {
            navigationType = NavigationType.BOTTOM_NAVIGATION
            contentType = ContentType.LIST_ONLY
        }
    }
    /*pass navigationType to NavWrapperUi() composable call*/
    NavigationWrapperUi(
        navigationType,
        contentType,
        navController = navController,
        viewModel = viewModel
    )
}

@Preview(showBackground = true)
@Composable
fun RootScreenPreview() {
    UiTheme {
        AppMainScreen(
            windowSize = WindowWidthSizeClass.Compact,
            foldingPosture = DevicePosture.NormalPosture
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RootScreenPreviewTablet() {
    UiTheme {
        AppMainScreen(
            windowSize = WindowWidthSizeClass.Medium,
            foldingPosture = DevicePosture.NormalPosture
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RootScreenPreviewDesktop() {
    UiTheme {
        AppMainScreen(
            windowSize = WindowWidthSizeClass.Expanded,
            foldingPosture = DevicePosture.NormalPosture
        )
    }
}