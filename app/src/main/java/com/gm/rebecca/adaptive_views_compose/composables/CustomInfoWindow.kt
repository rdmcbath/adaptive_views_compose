package com.gm.rebecca.adaptive_views_compose.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gm.rebecca.adaptive_views_compose.ui.theme.UiTheme

@Composable
fun CustomInfoWindow(title: String?, description: String?) {
    Column(
        modifier = Modifier
            .wrapContentWidth()
            .background(Color.Blue)
            .padding(6.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            title ?: "Title",
            color = Color.White,
        )
        Text(
            description ?: "Description",
            color = Color.White,
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp, start = 25.dp, end = 25.dp)
        )
    }
}

@Preview
@Composable
fun CustomInfoWindowPreview() {
    UiTheme {
        CustomInfoWindow(title = "Test", description = "Test here and there")
    }
}