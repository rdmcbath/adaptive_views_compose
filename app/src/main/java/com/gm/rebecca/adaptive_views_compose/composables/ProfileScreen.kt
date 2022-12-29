package com.gm.rebecca.adaptive_views_compose.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun ProfileScreen() {
    Text(
        text = "Profile goes here! Nothing yet 🤪",
        modifier = Modifier.fillMaxSize().padding(32.dp),
        fontSize = 21.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily.SansSerif,
        textAlign = TextAlign.Center
    )
}