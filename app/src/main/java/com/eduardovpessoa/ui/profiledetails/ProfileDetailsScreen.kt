package com.eduardovpessoa.ui.profiledetails

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Map
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eduardovpessoa.R
import com.eduardovpessoa.data.dto.Profile
import com.eduardovpessoa.data.dto.Profiles
import com.eduardovpessoa.ui.composables.DivvyToolbar
import java.util.*

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun ProfileDetailsScreen(
    profile: Profile,
    onBackPressed: () -> Unit
) {
    Scaffold(
        topBar = {
            DivvyToolbar(title = stringResource(R.string.profile_details), true) {
                onBackPressed()
            }
        },
        content = {
            ProfileDetailsScreenInfo(profile = profile, paddingValues = it)
        }
    )
}

@Composable
fun ProfileDetailsScreenInfo(profile: Profile, paddingValues: PaddingValues) {
    val context = LocalContext.current
    val state = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(state, enabled = true)
            .fillMaxWidth()
            .padding(top = paddingValues.calculateTopPadding(), start = 16.dp, end = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.name),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = profile.name.orEmpty(),
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.address),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )
        Text(
            text = profile.street.orEmpty(),
            fontSize = 18.sp,
            maxLines = 2,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier.align(CenterHorizontally),
            onClick = {
                // Display a label at the location of Google's Sydney office
                val gmmIntentUri = Uri.parse("geo:0,0?q=${"address"}")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                context.startActivity(mapIntent)
            }) {
            Icon(imageVector = Icons.Rounded.Map, contentDescription = "")
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = stringResource(R.string.open_maps))
        }
        Spacer(modifier = Modifier.height(32.dp))
    }
}
