package com.gm.rebecca.adaptive_views_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.window.layout.FoldingFeature
import androidx.window.layout.WindowInfoTracker
import com.gm.rebecca.adaptive_views_compose.composables.AppMainScreen
import com.gm.rebecca.adaptive_views_compose.ui.theme.UiTheme
import com.gm.rebecca.adaptive_views_compose.util.DevicePosture.*
import com.gm.rebecca.adaptive_views_compose.util.isBookPosture
import com.gm.rebecca.adaptive_views_compose.util.isSeparating
import com.google.android.gms.location.FusedLocationProviderClient
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class BasicMapActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        // Switch to AppTheme for displaying the activity
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)

        /*using Kotlin Flows to work with WindowLayoutInfo data collection - this uses map operator and display
           information returned by windowLayoutInfo(activity: Activity) to determine the device fold posture.*/
        val devicePostureFlow = WindowInfoTracker.getOrCreate(this)
            .windowLayoutInfo(this)
            .flowWithLifecycle(this.lifecycle)
            .map { layoutInfo ->
                val foldingFeature =
                    layoutInfo.displayFeatures
                        .filterIsInstance<FoldingFeature>()
                        .firstOrNull()
                when {
                    isBookPosture(foldingFeature) ->
                        BookPosture(foldingFeature.bounds)

                    isSeparating(foldingFeature) ->
                        Separating(foldingFeature.bounds, foldingFeature.orientation)

                    else -> NormalPosture
                }
            }
            .stateIn(
                scope = lifecycleScope,
                started = SharingStarted.Eagerly,
                initialValue = NormalPosture
            )

        setContent {
            UiTheme {
                /*returns the window size class for the provided activity*/
                val windowSize = calculateWindowSizeClass(activity = this).widthSizeClass
                /*observe device posture as compose state*/
                val devicePosture = devicePostureFlow.collectAsState().value
                AppMainScreen(
                    windowSize,
                    devicePosture,
                    viewModel = viewModel,
                )
            }
        }
    }
}

