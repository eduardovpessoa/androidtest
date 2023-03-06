package com.eduardovpessoa.ui.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@ExperimentalMaterial3Api
@Composable
fun DivvyToolbar(
    title: String,
    showBackArrow: Boolean,
    onBackClick: () -> Unit
) {
    val noIcon: @Composable (() -> Unit) = {}
    val navigationIcon: @Composable (() -> Unit) = {
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back"
            )
        }
    }
    TopAppBar(
        title = { Text(title) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
        ),
        navigationIcon = if (showBackArrow) navigationIcon else noIcon
    )
}