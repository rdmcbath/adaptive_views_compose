package com.gm.rebecca.adaptive_views_compose.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.gm.rebecca.adaptive_views_compose.MainViewModel
import com.gm.rebecca.adaptive_views_compose.util.ContentType
import com.gm.rebecca.adaptive_views_compose.util.NavigationType
import kotlinx.coroutines.launch

/*Wrapper that uses navigationType to determine placement of navigation rail or
bottom navigation to implement dynamic navigation on different devices.
For compact window size class like a phone, the app uses bottom navigation
In a medium window size class, the app uses a navigation rail
The app uses a permanent navigation drawer in an expanded window size class*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationWrapperUi(
    navigationType: NavigationType,
    contentType: ContentType,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: MainViewModel = viewModel()
) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val closeDrawer: () -> Unit = { scope.launch { drawerState.close() } }

    if (navigationType == NavigationType.PERMANENT_NAVIGATION_DRAWER) {
        PermanentNavigationDrawer(
            drawerContent = {
                PermanentDrawerSheet(Modifier.fillMaxWidth(0.5f)) {
                    NavigationDrawerContent(
                        navController = navController
                    )
                }
            }
        ) {
            AppContent(
                navigationType = navigationType,
                contentType = contentType,
                modifier = modifier,
                navController = navController,
                viewModel = viewModel
            )
        }
    } else {
        ModalNavigationDrawer(
            drawerContent = {
                NavigationDrawerContent(
                    navController = navController,
                    onDrawerClicked = {
                        closeDrawer
                    }
                )
            },
            drawerState = drawerState
        ) {
            AppContent(
                navigationType = navigationType,
                modifier = modifier,
                navController = navController,
                viewModel = viewModel,
                onDrawerClicked = {
                    scope.launch {
                        drawerState.open()
                    }
                },
                contentType = contentType
            )
        }
    }
}