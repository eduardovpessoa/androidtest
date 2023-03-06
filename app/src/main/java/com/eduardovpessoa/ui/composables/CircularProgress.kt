package com.eduardovpessoa.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DivvyCircularProgressIndicator(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = paddingValues.calculateTopPadding())
    ) {
        Spacer(Modifier.height(16.dp))
        CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
    }
}